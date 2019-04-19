package ru.otus.igorr.books.lesson12.config;

import com.mongodb.MongoClient;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

//@Configuration
//@EnableMongoRepositories(basePackages = "ru.otus.igorr.books.lesson12.repository")
//@EnableConfigurationProperties({MongoDbProps.class})
public class MongoConfig extends AbstractMongoConfiguration {

    private MongoProps props;

    public MongoConfig(MongoProps props) {
        this.props = props;
    }

    @Override
    public MongoClient mongoClient() {
        //return new MongoClient(props.getHost(), 27017);
        //String host = "mongodb+srv://igorr:DfczGegrby123@cluster0-x1evu.gcp.mongodb.net/testdb";
        //String.format(props.getHost(), props.getUsername(), props.getPassword(), props.getDbname());
        String host = "mongodb+srv://igorr:9FnEH8OfZR6VKKio@cluster0-x1evu.gcp.mongodb.net:27017";
        //String host = "cluster0-x1evu.gcp.mongodb.net/testdb";
        //return new MongoClient(host, 21017);
        return new MongoClient(host);
    }

    @Override
    protected String getDatabaseName() {
        return props.getDatabase();
    }


}
