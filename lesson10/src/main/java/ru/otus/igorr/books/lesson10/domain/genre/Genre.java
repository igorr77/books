package ru.otus.igorr.books.lesson10.domain.genre;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

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
