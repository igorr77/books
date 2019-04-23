package ru.otus.igorr.books.lesson12.events;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson12.domain.book.Book;
import ru.otus.igorr.books.lesson12.repository.author.AuthorRepository;
import ru.otus.igorr.books.lesson12.repository.book.BookRepository;
import ru.otus.igorr.books.lesson12.repository.genre.GenreRepository;

import java.util.Objects;

@Component
public class BookCascadeSaveEventListener extends AbstractMongoEventListener<Book> {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;

    @Autowired
    public BookCascadeSaveEventListener(AuthorRepository authorRepository, GenreRepository genreRepository) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Book> event) {
        super.onBeforeConvert(event);

        Book book = event.getSource();
        if (book.getAuthors() != null) {
            book.getAuthors().stream()
                    //.filter(e-> Objects.isNull(e.getId()))
                    .forEach(authorRepository::save);
        }

        if (book.getGenre() != null) {
            genreRepository.save(book.getGenre());
        }
    }
}
