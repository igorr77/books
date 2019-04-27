package ru.otus.igorr.books.lesson08.domain.genre;


import javax.persistence.*;

@Entity
public class Genre {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
