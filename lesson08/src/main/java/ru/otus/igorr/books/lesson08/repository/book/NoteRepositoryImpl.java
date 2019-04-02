package ru.otus.igorr.books.lesson08.repository.book;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.igorr.books.lesson08.domain.book.Note;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class NoteRepositoryImpl implements NoteRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public void add(Note note) {
        em.persist(note);
    }
}
