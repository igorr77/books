package ru.otus.igorr.books.lesson08.repository.book;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.igorr.books.lesson08.domain.book.Book;
import ru.otus.igorr.books.lesson08.domain.book.Note;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;

@Repository
@Transactional
public class BookRepositoryImpl implements BookRepository {

    @PersistenceContext//(type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Book getById(int id) {
        return em.find(Book.class, id);
    }

    @Override
    public void save(Book book) {
        if (book.getId() == 0) {
            em.persist(book);
        } else {
            em.merge(book);
        }
    }

    @Override
    public List<Book> getList() {
        return null;
    }

    @Override
    public void delete(Book book) {

    }

    @Override
    public void addNote(Book book, Note note) {

    }
}
