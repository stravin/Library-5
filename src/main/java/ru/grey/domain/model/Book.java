package ru.grey.domain.model;

import org.hibernate.annotations.CollectionOfElements;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by stravin on 17.06.2014.
 */
@Entity
@Table(name = "book")
public class Book extends BaseEntity implements Serializable {
    static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    public Book() {
    }

    @ManyToOne(targetEntity = Genre.class)
    @JoinColumn(name = "genre_id", insertable = false, updatable = false)
    private Genre genre;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
    private Set<Author> authors = new HashSet<Author>();

    public Set<Author> getAuthors() {
        return this.authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", year=" + year +
                ", genre=" + genre +
                ", authors=" + authors +
                '}';
    }
}
