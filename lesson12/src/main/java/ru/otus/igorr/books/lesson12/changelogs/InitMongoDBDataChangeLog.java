package ru.otus.igorr.books.lesson12.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import lombok.val;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.igorr.books.lesson12.domain.author.Author;
import ru.otus.igorr.books.lesson12.domain.author.AuthorName;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;

@ChangeLog(order = "001")
public class InitMongoDBDataChangeLog {

    private Genre genre1;
    private Genre genre2;
    private Genre genre3;
    private Genre genre999;
    private Author author1;
    private Author author2;

    @ChangeSet(order = "000", id = "dropDB", author = "other", runAlways = true)
    public void dropDB(MongoDatabase database){
        database.drop();
    }

    @ChangeSet(order = "001", id = "initGenres", author = "other", runAlways = true)
    public void initGenres(MongoTemplate template){
        genre1 = template.save(new Genre("1", "Init.Genre.Name.1", "Init.Genre.Description.1"));
        genre2 = template.save(new Genre("2", "Init.Genre.Name.2", "Init.Genre.Description.2"));
        genre3 = template.save(new Genre("3", "Init.Genre.Name.3", "Init.Genre.Description.3"));
        genre999 = template.save(new Genre("3", "Init.Genre.Name.3", "Init.Genre.Description.3"));
        template.save(new Genre(null, "Init.Genre.Name.*", "Init.Genre.Description.*"));
    }

    @ChangeSet(order = "002", id = "initAuthors", author = "other", runAlways = true)
    public void initAuthors(MongoTemplate template){
        val authorName = new AuthorName("Init:Firstname","Surname","Lastname");
        author1 = template.save(new Author(authorName, genre1, genre2, genre3, genre999));
    }

    @ChangeSet(order = "003", id = "initBooks", author = "other", runAlways = true)
    public void initBooks(MongoTemplate template){
        // TODO: 19.04.2019
    }


}
