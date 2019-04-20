package ru.otus.igorr.books.lesson10.repository.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.otus.igorr.books.lesson10.domain.book.Book;
import ru.otus.igorr.books.lesson10.domain.book.Note;

import java.util.Optional;
import java.util.Set;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    @Override
    <S extends Note> S saveAndFlush(S s);

    @Override
    void flush();

    @Override
    Optional<Note> findById(Long aLong);

    @Query("select n from Note n where n.book = :book")
    Set<Note> findByBook(@Param("book") Book book);

    @Override
    Page<Note> findAll(Pageable pageable);

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(Note note);


}
