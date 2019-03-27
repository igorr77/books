package ru.otus.igorr.books.lesson06.services.genre;

import ru.otus.igorr.books.lesson06.domain.Genre;

import java.util.List;

public interface GenreService {
    /**
     * @param id
     * @return
     */
    Genre get(int id);

    /**
     * @param genre
     * @return
     */
    int save(Genre genre);

    /**
     * @param genre
     * @return
     */
    int delete(Genre genre);

    /**
     * @param condition
     * @return
     */
    List<Genre> getList(String condition);

    /**
     * @return
     */
    int getMaxId();

}
