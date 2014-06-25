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
@Table(name = "author")
public class Author extends BaseEntity implements Serializable {
    static final long serialVersionUID = 1L;

    @Column(name = "fio")
    private String fio;

    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @Column(name = "bio")
    private String biography;

    public Author() {
    }

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "authors")
    private Set<Book> books = new HashSet<Book>();

    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public void addBook(Book book) {
        if (this.books == null) {
            books = new HashSet<Book>();
        }
        this.books.add(book);
    }

    public void deleteBook(Book book) {
        this.books.remove(book);
    }

    @Override
    public String toString() {
        return "Author{" +
                "fio='" + fio + '\'' +
                ", yearOfBirth=" + yearOfBirth +
                ", biography='" + biography + '\'' +
                //", books=" + books +
                '}';
    }
}
