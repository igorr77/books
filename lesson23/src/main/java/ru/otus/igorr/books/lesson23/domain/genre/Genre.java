package ru.otus.igorr.books.lesson23.domain.genre;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.xml.bind.annotation.XmlRootElement;

import static ru.otus.igorr.books.lesson23.utils.Constant.NOT_FOUND_DOCUMENT_ID;

@Document(collection = "Genre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Genre {

    @Id
    private String id;

    @Field("name")
    @Indexed
    private String name;

    @Field("description")
    private String description;

    private static Genre instance;

    public static final Genre empty() {
        if (instance == null) {
            instance = new Genre();
            instance.setId(NOT_FOUND_DOCUMENT_ID);
        }
        return instance;
    }


    @Override
    public boolean equals(Object obj) {

        if (obj == null) {
            return false;
        }
        if (!Genre.class.isAssignableFrom(obj.getClass())) {
            return false;
        }

        final Genre other = (Genre) obj;

        /* Минимум */

        if (this.id != other.getId()) {
            return false;
        }
        if (!this.name.equals(other.getName())) {
            return false;
        }
        if (!this.description.equals(other.getDescription())) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
