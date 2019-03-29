package ru.otus.igorr.books.lesson06.dao.genre;

import ru.otus.igorr.books.lesson06.domain.Genre;

import java.util.List;
import java.util.Optional;

public interface GenreDao {
    Optional<Genre> get(int id);

    /**
     * Сохранение сущности
     *
     * @param genre
     * @return 0 - ошибка при сохранении, !0 - genreId
     */
    int save(Genre genre);

    /**
     * @param genre
     * @return Колличество удаленных записей
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
