package ru.otus.igorr.books.lesson15.utils;

import ru.otus.igorr.books.lesson15.domain.author.Author;
import ru.otus.igorr.books.lesson15.domain.author.AuthorName;
import ru.otus.igorr.books.lesson15.domain.book.Book;
import ru.otus.igorr.books.lesson15.domain.book.Note;
import ru.otus.igorr.books.lesson15.domain.genre.Genre;
import ru.otus.igorr.books.lesson15.dto.NoteDto;

import java.util.ArrayList;
import java.util.List;

public class PrepareDataHelper {


    public static Book prepareBook() {
        Book book = new Book();
        List<Author> authorList = prepareAuthorList(3);


        book.setTitle("Book.Title.AddNote");
        //book.setAuthorList(authorList);
        book.setGenre(prepareGenre("1"));
        book.setDescription("Book.Description");

        return book;
    }

    public static Genre prepareGenre(String n) {
        Genre genre = new Genre();
        genre.setId(n);
        genre.setName("Book.Genre: " + n);
        genre.setDescription("Book.Description: " + n);
        return genre;
    }

    public static List<Author> prepareAuthorList(int count) {
        List<Author> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(prepareAuthor(String.valueOf(i)));
        }
        return list;
    }

    public static Author prepareAuthor(String i) {
        Author author = new Author();
        author.setId(i);
        author.setName(prepareAuthorName(i));
        author.setGenres(prepareGenreList(2));
        return author;
    }

    public static List<Genre> prepareGenreList(int count) {
        List<Genre> list = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            list.add(prepareGenre(String.valueOf(i)));
        }
        return list;
    }

    public static AuthorName prepareAuthorName(String i) {
        AuthorName authorName = new AuthorName();
        authorName.setFirstName("Firstname" + i);
        authorName.setLastName("Lastname" + i);
        authorName.setSurName("Surname" + i);
        return authorName;
    }

    public static Note prepareNote(int n) {
        Note note = new Note();
        note.setNote("Note. Add text to book: " + n);
        return note;
    }

    public static NoteDto prepareNoteDto(String n) {
        NoteDto dto = new NoteDto();
        dto.setId(n);
        dto.setText("Note.PrepareDataHelper: " + n);
        return dto;
    }
}
