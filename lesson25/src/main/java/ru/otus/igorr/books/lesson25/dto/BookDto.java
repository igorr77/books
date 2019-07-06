package ru.otus.igorr.books.lesson25.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class BookDto {
    private String id;
    private String title;
    private List<AuthorDto> authorList;
    private GenreDto genre;
    private String description;
    private boolean isNote;

    private BookDto(Builder builder) {
        this.id = builder.id;
        this.title = builder.title;
        this.authorList = builder.authorList;
        this.genre = builder.genre;
        this.description = builder.description;
        this.isNote = builder.isNote;
    }

    public static class Builder {
        private String id;
        private String title;
        private List<AuthorDto> authorList;
        private GenreDto genre;
        private String description;
        private boolean isNote;

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder authorList(List<AuthorDto> authorList) {
            this.authorList = authorList;
            return this;
        }

        public Builder genre(GenreDto genre) {
            this.genre = genre;
            return this;
        }

        public Builder description(String description) {
            this.description = description;
            return this;
        }

        public Builder isNote(boolean note) {
            this.isNote = note;
            return this;
        }


        public BookDto build() {
            return new BookDto(this);
        }

    }

    @Override
    public String toString() {
        return "BookDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", authorList=" + authorList +
                ", genre=" + genre +
                ", description='" + description + '\'' +
                ", isNote="+ isNote +
                '}';
    }
}
