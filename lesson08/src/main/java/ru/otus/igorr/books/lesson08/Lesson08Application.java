package ru.otus.igorr.books.lesson08;


import org.h2.tools.Console;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import ru.otus.igorr.books.lesson08.config.MessagesProps;

import java.sql.SQLException;

@SpringBootApplication
@EnableConfigurationProperties(MessagesProps.class)
public class Lesson08Application {

    private static final Logger LOG = LoggerFactory.getLogger(Lesson08Application.class);

    public static void main(String[] args) throws SQLException {
        LOG.info("Start app");
        ApplicationContext context = SpringApplication.run(Lesson08Application.class);
        Console.main(args);
        LOG.info("Stop app");
    }

}
