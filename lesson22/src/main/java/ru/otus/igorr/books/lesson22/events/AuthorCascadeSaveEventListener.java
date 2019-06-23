package ru.otus.igorr.books.lesson22.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson22.domain.author.Author;
import ru.otus.igorr.books.lesson22.repository.genre.GenreRepository;

import java.util.Objects;

@Component
public class AuthorCascadeSaveEventListener extends AbstractMongoEventListener<Author> {

    private final GenreRepository genreRepository;

    @Autowired
    public AuthorCascadeSaveEventListener(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Author> event) {
        super.onBeforeConvert(event);

        Author author = event.getSource();
        if (author.getGenres() != null) {
            author.getGenres().stream()
                    .filter(e -> Objects.isNull(e.getId()))
                    .forEach(genreRepository::save);
        }
    }
}
