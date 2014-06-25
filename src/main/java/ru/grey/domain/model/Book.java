package ru.grey.domain.model;

import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
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
    @JoinColumn(name = "genre_id")
    private Genre genre;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ref_authors_books",
            joinColumns = @JoinColumn(name = "book_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "author_id", referencedColumnName = "id"))
    private Set<Author> authors = new HashSet<Author>();

    @Transient
    private Long[] authorids;

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

    public Long[] getAuthorids() {
        return authorids;
    }

    public void setAuthorids(Long[] authorids) {
        this.authorids = authorids;
    }

    public void addAuthor(Author author) {
        if (this.authors == null) {
            authors = new HashSet<Author>();
        }
        this.authors.add(author);
    }

    public void deleteAuthor(Author author) {
        this.authors.remove(author);
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
