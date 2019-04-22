package ru.otus.igorr.books.lesson12.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties("spring.data.mongodb")
//@ConfigurationProperties(prefix = "mongodb", ignoreInvalidFields = true)
public class MongoProps {
    private int port;
    private String database;
    private String uri;
}
