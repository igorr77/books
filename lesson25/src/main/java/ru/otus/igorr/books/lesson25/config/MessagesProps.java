package ru.otus.igorr.books.lesson25.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "messages", ignoreInvalidFields = true)
public class MessagesProps {
    private String bundle;
    private String language;
    private String country;

}
