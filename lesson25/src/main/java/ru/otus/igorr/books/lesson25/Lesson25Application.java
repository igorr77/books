package ru.otus.igorr.books.lesson25;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import ru.otus.igorr.books.lesson25.config.MessagesProps;

import java.sql.SQLException;

@SpringBootApplication
@EnableConfigurationProperties({MessagesProps.class})
@EnableJpaRepositories("ru.otus.igorr.books.lesson25.repository.jpa")
@EnableMongoRepositories("ru.otus.igorr.books.lesson25.repository.mongo")
public class Lesson25Application {

    private static final Logger LOG = LoggerFactory.getLogger(Lesson25Application.class);

    public static void main(String[] args) throws SQLException {
        LOG.info("Start app");
        ApplicationContext context = SpringApplication.run(Lesson25Application.class);
        LOG.info("Stop app");
    }

}
