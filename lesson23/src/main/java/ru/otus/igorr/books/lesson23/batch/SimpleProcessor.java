package ru.otus.igorr.books.lesson23.batch;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
import ru.otus.igorr.books.lesson23.domain.mongo.genre.Genre;

import java.time.LocalTime;

@Component
public class SimpleProcessor implements ItemProcessor<Genre, Genre> {

    private Long id = 0L;

    @Override
    public Genre process(Genre genre) throws Exception {

        LocalTime today = LocalTime.now();
        genre.setDescription(genre.getDescription() + ": " + today);

        int i = 10;
        while (i-- > 0) {
            System.out.print(".");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();

        genre.setId(String.valueOf(++id));
        return genre;
    }
}
