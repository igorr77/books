package ru.otus.igorr.books.lesson12.events;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson12.domain.author.Author;
import ru.otus.igorr.books.lesson12.repository.genre.GenreRepository;

@Component
public class AuthorCascadeSaveEventListener extends AbstractMongoEventListener<Author> {

    private final GenreRepository genreRepository;

    @Autowired
    public AuthorCascadeSaveEventListener(GenreRepository genreRepository){
        this.genreRepository = genreRepository;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Author> event) {
        super.onBeforeConvert(event);

        Author author = event.getSource();
        if(author.getGenres() != null) {
            // TODO: 23.04.2019 Предполагается, что если genreId is not null, то сохранять не нужно, пока сохраняем все
            author.getGenres().stream()
                    //.filter(e -> Objects.isNull(e.getId()))
                    .forEach(genreRepository::save);
        }
    }
}
