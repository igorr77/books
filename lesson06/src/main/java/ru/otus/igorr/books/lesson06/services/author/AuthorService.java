package ru.otus.igorr.books.lesson06.services.author;

import ru.otus.igorr.books.lesson06.domain.Author;

import java.util.List;

public interface AuthorService {
    /**
     * @param id
     * @return
     */
    Author get(int id);

    /**
     * @param author
     * @return
     */
    int save(Author author);

    /**
     * @param author
     * @return
     */
    int delete(Author author);

    /**
     * @param condition
     * @return
     */
    List<Author> getList(String condition);

    /**
     * @return
     */
    int ghetMaxId();
}
