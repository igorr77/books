package ru.otus.igorr.books.lesson12.config;

import com.mongodb.MongoClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "ru.otus.igorr.books.lesson12.repository")
@EnableConfigurationProperties({MongoDbProps.class})
public class MongoConfig extends AbstractMongoConfiguration {

    private MongoDbProps props;

    public MongoConfig(MongoDbProps props) {
        this.props = props;
    }

    @Override
    public MongoClient mongoClient() {
        return new MongoClient("127.0.0.1", 27017);
    }

    @Override
    protected String getDatabaseName() {
        return props.getDbname();
    }


}
