package ru.otus.igorr.books.lesson12.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "mongodb", ignoreInvalidFields = true)
@Getter
@Setter
public class MongoDbProps {
    private String dbname;
}
