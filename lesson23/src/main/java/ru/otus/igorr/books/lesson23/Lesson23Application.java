package ru.otus.igorr.books.lesson23;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.otus.igorr.books.lesson23.config.MessagesProps;

import java.sql.SQLException;

@SpringBootApplication
@EnableConfigurationProperties({MessagesProps.class})
@EnableJpaRepositories("ru.otus.igorr.books.lesson23.repository.jpa")
@EnableMongoRepositories("ru.otus.igorr.books.lesson23.repository.mongo")
public class Lesson23Application {

    private static final Logger LOG = LoggerFactory.getLogger(Lesson23Application.class);

    public static void main(String[] args) throws SQLException {
        LOG.info("Start app");
        ApplicationContext context = SpringApplication.run(Lesson23Application.class);
        LOG.info("Stop app");
    }

}
