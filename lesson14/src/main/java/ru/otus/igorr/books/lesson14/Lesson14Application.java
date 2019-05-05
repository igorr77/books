package ru.otus.igorr.books.lesson14;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import ru.otus.igorr.books.lesson14.config.MessagesProps;

import java.sql.SQLException;

@SpringBootApplication
@EnableConfigurationProperties({MessagesProps.class})
public class Lesson14Application {

    private static final Logger LOG = LoggerFactory.getLogger(Lesson14Application.class);

    public static void main(String[] args) throws SQLException {
        LOG.info("Start app");
        ApplicationContext context = SpringApplication.run(Lesson14Application.class);
        LOG.info("Stop app");
    }

}
