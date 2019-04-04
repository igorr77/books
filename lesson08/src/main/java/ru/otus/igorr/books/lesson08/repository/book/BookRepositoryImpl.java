package ru.otus.igorr.books.lesson08.repository.book;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.igorr.books.lesson08.domain.author.Author;
import ru.otus.igorr.books.lesson08.domain.book.Book;
import ru.otus.igorr.books.lesson08.domain.book.Note;
import ru.otus.igorr.books.lesson08.domain.genre.Genre;
import ru.otus.igorr.books.lesson08.dto.BookDto;
import ru.otus.igorr.books.lesson08.dto.BookDtoConverter;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext//(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public BookDto getById(int id) {
        Book book = em.find(Book.class, id);
        return new BookDtoConverter().convert(book);
    }

    @Override
    public int save(Book book) {
        if (book.getId() == 0) {
            em.persist(book);
        } else {
            em.merge(book);
        }
        int breakPoint = 0;
        return book.getId();
    }

    @Override
    public List<Book> getList() {
        List<Book> result = em.createQuery("select e from Book e").getResultList();
        return result;
    }

    @Override
    public void delete(Book book) {
        em.remove(em.contains(book) ? book : em.merge(book));
    }
    @Override
    public void addNote(Book book, Note note) {

    }
}
