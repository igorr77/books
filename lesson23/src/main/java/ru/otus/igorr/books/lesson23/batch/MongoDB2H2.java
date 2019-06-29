package ru.otus.igorr.books.lesson23.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.oxm.xstream.XStreamMarshaller;
import ru.otus.igorr.books.lesson23.domain.genre.Genre;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Configuration
@EnableBatchProcessing
public class MongoDB2H2 {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    MongoTemplate mongoTemplate;

    @Bean
    public Job readGenre() throws Exception {
        LOG.debug("#############################################: readGenre");
        return jobBuilderFactory.get("readGenre")
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    Step step1() throws Exception {
        LOG.debug("#############################################: step1");
        return stepBuilderFactory.get("step1")
                .<Genre, Genre>chunk(5)
                .reader(reader())
                .writer(writer())
                .build();
    }


    @Bean
    public MongoItemReader<Genre> reader() {
        LOG.debug("#############################################: reader");
        MongoItemReader<Genre> reader = new MongoItemReader<>();
        reader.setTemplate(mongoTemplate);
        reader.setSort(new HashMap<String, Sort.Direction>() {{
            put("_id", Sort.Direction.DESC);
        }});
        reader.setTargetType(Genre.class);
        reader.setQuery("{}");
        return reader;
    }


    @Bean
    public FlatFileItemWriter<Genre> writer() {
        LOG.debug("#############################################: writer");
        FlatFileItemWriter<Genre> writer = new FlatFileItemWriter<>();
        writer.setResource(new FileSystemResource("csv/genre.csv"));
        DelimitedLineAggregator<Genre> aggregator = new DelimitedLineAggregator<>();
        aggregator.setDelimiter("|");

        //BeanWrapperFieldExtractor extractor = new BeanWrapperFieldExtractor();
        //extractor.setNames(new String[] { "id", "price", "name" });
        //aggregator.setFieldExtractor(extractor);

        writer.setLineAggregator(aggregator);
        return writer;
    }



}
