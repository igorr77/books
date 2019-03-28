package ru.otus.igorr.books.lesson06;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.otus.igorr.books.lesson06.config.MessagesProps;

@SpringBootApplication
@EnableConfigurationProperties(MessagesProps.class)
public class Lesson06Application {

    private static final Logger LOG = LoggerFactory.getLogger(Lesson06Application.class);

    public static void main(String[] args){
        SpringApplication.run(Lesson06Application.class);
    }

}
