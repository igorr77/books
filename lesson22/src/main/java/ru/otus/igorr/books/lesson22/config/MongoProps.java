package ru.otus.igorr.books.lesson22.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Getter
@Setter
@Component
@ConfigurationProperties("spring.data.mongodb")
public class MongoProps {
    private String host;
    private int port;
    private String database;
    private String uri;
}
