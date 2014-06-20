package ru.grey.domain.service.impl;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.grey.domain.model.Author;
import ru.grey.domain.model.Book;
import ru.grey.domain.service.AuthorService;
import ru.grey.domain.service.BookService;

import java.util.List;

/**
 * Created by stravin on 18.06.2014.
 */
public class Start {
    protected static ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext(new String[]{"mvc-dispatcher-servlet.xml"});

    public static void main(String[] args) {

        /* Tests for authors */

        AuthorService authorService = (AuthorService) classPathXmlApplicationContext.getBean("authorServiceImpl");
//        Author author = authorService.findById(1L);
//        System.out.println(author);

        // new author
        Author newAuthor = new Author();
        newAuthor.setFio("Ivanov Ivan Ivanovich");
        newAuthor.setYearOfBirth(1950);
        newAuthor.setBiography("He was born...");
        // save it
        authorService.addAuthor(newAuthor);

        List<Author> authors = authorService.findAll();
        for (Author a : authors) {
            System.out.println(a);
        }

        /* Tests for books */

        BookService bookService = (BookService) classPathXmlApplicationContext.getBean("bookServiceImpl");
//        Book book = bookService.findById(3L);
//        System.out.println(book);

        List<Book> books = bookService.findAll();
        for (Book b : books) {
            System.out.println(b);
        }

        Book bookForModify = bookService.findById(1L);
        bookForModify.setYear(2000);
        bookService.updateBook(bookForModify);

        List<Book> booksAfterMod = bookService.findAll();
        for (Book b : booksAfterMod) {
            System.out.println(b);
        }
    }
}
