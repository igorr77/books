package ru.otus.igorr.books.lesson12.domain.genre;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static ru.otus.igorr.books.lesson12.utils.Constant.NOT_FOUND_ENTITY_ID;

@Entity
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    private static Genre instance;

    public static final Genre empty(){
        if (instance == null) {
            instance = new Genre();
            instance.setId(NOT_FOUND_ENTITY_ID);
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
}
