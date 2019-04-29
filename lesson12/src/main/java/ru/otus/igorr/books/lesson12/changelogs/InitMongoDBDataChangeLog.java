package ru.otus.igorr.books.lesson12.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.mongodb.client.MongoDatabase;
import lombok.val;
import org.springframework.data.mongodb.core.MongoTemplate;
import ru.otus.igorr.books.lesson12.domain.author.Author;
import ru.otus.igorr.books.lesson12.domain.author.AuthorName;
import ru.otus.igorr.books.lesson12.domain.book.Book;
import ru.otus.igorr.books.lesson12.domain.book.Note;
import ru.otus.igorr.books.lesson12.domain.genre.Genre;

import java.util.Arrays;
import java.util.List;

@ChangeLog(order = "001")
public class InitMongoDBDataChangeLog {

    private Genre genre1;
    private Genre genre2;
    private Genre genre3;
    private Genre genreForDelete;
    private Author author1;
    private Author author2;
    private Author authorForDel;
    private Author authorNoDel;
    private Book book1;
    private Book book2;

    @ChangeSet(order = "000", id = "dropDB", author = "other", runAlways = true)
    public void dropDB(MongoDatabase database){
        database.drop();
    }

    @ChangeSet(order = "001", id = "initGenres", author = "other", runAlways = true)
    public void initGenres(MongoTemplate template){
        genre1 = template.save(new Genre("1", "Get.Genre.Name.1", "Init.Genre.Description.1"));
        genre2 = template.save(new Genre("2", "Get.Genre.Name.2", "Init.Genre.Description.2"));
        genre3 = template.save(new Genre("3", "Get.Genre.Name.3", "Init.Genre.Description.3"));
        template.save(new Genre("888L", "Del.Genre.Name.888L", "Init.Genre.Description.888L"));
        genreForDelete = template.save(new Genre("999L", "Del.Genre.Name.999L", "Init.Genre.Description.999L"));
        template.save(new Genre(null, "Init.Genre.Name.*", "Init.Genre.Description.*"));
    }

    @ChangeSet(order = "002", id = "initAuthors", author = "other", runAlways = true)
    public void initAuthors(MongoTemplate template){
        val authorName = new AuthorName("Init:Firstname","Surname","Lastname");
        author1 = template.save(new Author("A1", authorName, genre1, genre2, genre3));
        author2 = template.save(new Author("A2", authorName, genre1, genre2));
        authorNoDel =template.save(new Author("A888", authorName, genre1, genre2, genre3));
        authorForDel = template.save(new Author("A999", authorName, genre1, genre2, genre3));
    }

    @ChangeSet(order = "003", id = "initBooks", author = "other", runAlways = true)
    public void initBooks(MongoTemplate template){

        List<Author> authorList = Arrays.asList(author1, author2);

        book1 = template.save(new Book("BID001", "Book.Title.1", authorList, genre1, "Init.Book.Description.1"));
        book2 = template.save(new Book("BID002", "Book.Title.2", authorList, genre1, "Init.Book.Description.2"));
        template.save(new Book("BID003", "Book.Title.3", authorList, genre1, "Init.Book.Description.3"));
        template.save(new Book("BDEL888", "Book.Title.888", Arrays.asList(authorNoDel), genre1, "Init.Book.Description.888"));
        template.save(new Book("BDEL999", "Book.Title.999", authorList, genre1, "Init.Book.Description.999"));
    }

    @ChangeSet(order = "004", id = "initNotes", author = "other", runAlways = true)
    public void initNotes(MongoTemplate template){

        List<Author> authorList = Arrays.asList(author1, author2);

        template.save(new Note("B1N1", "Book1.Note.1", book1));
        template.save(new Note("B2N1", "Book2.Note.1", book2));
        template.save(new Note("B2N2", "Book2.Note.2", book2));

    }


}
