package ru.otus.igorr.books.lesson25.integration;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.MessageChannels;

@Configuration
public class JmsConfig {

    @Bean("moderator")
    public DirectChannel moderator() {
        return MessageChannels.direct("chanelModerator").get();
    }

    @Bean("administrator")
    public DirectChannel cleaner() {
        return MessageChannels.direct("chanelAdmin").get();
    }
}
