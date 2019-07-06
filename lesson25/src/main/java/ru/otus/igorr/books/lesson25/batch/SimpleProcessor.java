package ru.otus.igorr.books.lesson25.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson25.domain.mongo.genre.Genre;

import java.time.LocalTime;

@Component
public class SimpleProcessor implements ItemProcessor<Genre, Genre> {

    private Long id = 0L;

    @Override
    public Genre process(Genre genre) throws Exception {

        LocalTime today = LocalTime.now();
        genre.setDescription(genre.getDescription() + ": " + today);

        System.out.print(".");
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        genre.setId(String.valueOf(++id));
        return genre;
    }
}
