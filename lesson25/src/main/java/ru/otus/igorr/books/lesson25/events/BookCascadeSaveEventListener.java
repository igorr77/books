package ru.otus.igorr.books.lesson25.events;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.AfterDeleteEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson25.domain.mongo.book.Book;
import ru.otus.igorr.books.lesson25.repository.mongo.author.AuthorRepository;
import ru.otus.igorr.books.lesson25.repository.mongo.book.NoteRepository;
import ru.otus.igorr.books.lesson25.repository.mongo.genre.GenreRepository;

import java.util.Objects;

@Component
public class BookCascadeSaveEventListener extends AbstractMongoEventListener<Book> {

    private final AuthorRepository authorRepository;
    private final GenreRepository genreRepository;
    private final NoteRepository noteRepository;

    @Autowired
    public BookCascadeSaveEventListener(AuthorRepository authorRepository,
                                        GenreRepository genreRepository,
                                        NoteRepository noteRepository) {
        this.authorRepository = authorRepository;
        this.genreRepository = genreRepository;
        this.noteRepository = noteRepository;
    }

    @Override
    public void onBeforeConvert(BeforeConvertEvent<Book> event) {
        super.onBeforeConvert(event);

        Book book = event.getSource();
        if (book.getAuthors() != null) {
            book.getAuthors().stream()
                    .filter(e -> Objects.isNull(e.getId()))
                    .forEach(authorRepository::save);
        }
        if (book.getGenre() != null && Objects.isNull(book.getGenre().getId())) {
            genreRepository.save(book.getGenre());
        }

    }

    @Override
    public void onAfterDelete(AfterDeleteEvent<Book> event) {
        super.onAfterDelete(event);

        Document book = event.getSource();
        String id = book.get("_id").toString();
        noteRepository.deleteByBookId(id);
    }
}
