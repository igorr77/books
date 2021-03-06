package ru.otus.igorr.books.lesson25.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.support.JobRegistryBeanPostProcessor;
import org.springframework.batch.core.configuration.support.MapJobRegistry;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.igorr.books.lesson25.domain.mongo.genre.Genre;

import javax.sql.DataSource;
import java.util.HashMap;

@Slf4j
@Configuration
@EnableBatchProcessing(modular = true)
public class MigrationJobConfig {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private DataSource dataSource;

    @Autowired
    SimpleProcessor simpleProcessor;

    @Bean
    public Job testJob() throws Exception {
        LOG.debug("#############################################: testJob");
        return jobBuilderFactory.get("migrationJob")
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    Step step1() throws Exception {
        LOG.debug("#############################################: step1");
        return stepBuilderFactory.get("step1")
                .<Genre, Genre>chunk(10)
                .reader(reader())
                .processor(simpleProcessor)
                //.writer(writer())
                .writer(genreWriter())
                .build();
    }


    @Bean
    public MongoItemReader<Genre> reader() {
        LOG.debug("#############################################: reader");
        MongoItemReader<Genre> reader = new MongoItemReader<>();
        reader.setTemplate(mongoTemplate);
        reader.setSort(new HashMap<String, Sort.Direction>() {{
            put("_id", Sort.Direction.ASC);
        }});
        reader.setTargetType(Genre.class);
        reader.setQuery("{}");
        return reader;
    }


    @Bean
    public FlatFileItemWriter<Genre> writer() {
        LOG.debug("#############################################: writer");
        FlatFileItemWriter<Genre> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource("log/genre.log"));
        DelimitedLineAggregator<Genre> aggregator = new DelimitedLineAggregator<>();
        aggregator.setDelimiter("|");

        writer.setLineAggregator(aggregator);
        return writer;
    }

    @Bean
    public JdbcBatchItemWriter<Genre> genreWriter() {
        LOG.debug("#############################################:genreWriter");

        JdbcBatchItemWriter<Genre> writer = new JdbcBatchItemWriter<>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO genre (id, name, description) VALUES (:id, :name, :description)");
        writer.setDataSource(dataSource);
        return writer;
    }

    @Bean
    public JobRegistry jobRegistry() {
        return new MapJobRegistry();
    }

    @Bean
    public JobRegistryBeanPostProcessor jobRegistryBeanPostProcessor() {
        JobRegistryBeanPostProcessor bpp = new JobRegistryBeanPostProcessor();
        bpp.setJobRegistry(jobRegistry());
        return bpp;
    }

}
