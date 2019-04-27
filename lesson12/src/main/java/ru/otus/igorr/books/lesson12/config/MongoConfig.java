package ru.otus.igorr.books.lesson12.config;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

public class MongoConfig extends AbstractMongoConfiguration {

    private MongoProps props;

    public MongoConfig(MongoProps props) {
        this.props = props;
    }

    @Override
    public MongoClient mongoClient() {
        String host = "localhost:27017";
        return new MongoClient(host);
    }

    @Override
    protected String getDatabaseName() {
        return props.getDatabase();
    }


}
