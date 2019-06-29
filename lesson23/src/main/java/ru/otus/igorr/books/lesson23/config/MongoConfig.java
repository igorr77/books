package ru.otus.igorr.books.lesson23.config;

import com.mongodb.MongoClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;


public class MongoConfig extends AbstractMongoConfiguration {

    private MongoProps props;

    public MongoConfig(MongoProps props) {
        this.props = props;
    }

    @Override
    public MongoClient mongoClient() {
        String host = props.getHost()+":"+props.getPort();
        return new MongoClient(host);
    }

    @Override
    protected String getDatabaseName() {
        return props.getDatabase();
    }


}
