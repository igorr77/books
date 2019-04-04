package ru.otus.igorr.books.lesson06.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "messages", ignoreInvalidFields = true)
@Getter
@Setter
public class MessagesProps {
    private String  bundle;
    private String language;
    private String country;

}
