package ru.otus.igorr.books.lesson06.services.message;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;

public interface MessageSources {
    String getMessage(String s);

    String getMessage(final MessageSourceResolvable messageSourceResolvable);

    boolean hasMessage(final MessageSource messageSource, final MessageSourceResolvable messageSourceResolvable);
}
