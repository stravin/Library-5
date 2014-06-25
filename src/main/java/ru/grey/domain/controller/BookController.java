package ru.grey.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.grey.domain.model.Author;
import ru.grey.domain.model.Book;
import ru.grey.domain.service.AuthorService;
import ru.grey.domain.service.BookService;
import ru.grey.domain.service.GenreService;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by stravin on 19.06.2014.
 */
@Controller
public class BookController {

    @Autowired
    private AuthorService authorService;

    @Autowired
    private BookService bookService;

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String listBooks(ModelMap model) {

        model.addAttribute("book", new Book());
        model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("genreList", genreService.findAll());

        return "books";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book")
                          Book book, BindingResult result) {

        bookService.addBook(book);

        return "redirect:/books";
    }

    @RequestMapping(value = "/books/edit/{bookId}", method = RequestMethod.GET)
    public String updateBookForm(ModelMap model, @PathVariable("bookId") Long bookId) {

        model.addAttribute("genreList", genreService.findAll());
        model.addAttribute("book", bookService.findById(bookId));

        Set<Author> bookAuthors = (Set<Author>) bookService.findById(bookId).getAuthors();
        model.addAttribute("bookauthors", bookAuthors);

        Set<Author> allAuthors = (Set<Author>) authorService.findAll();
        model.addAttribute("allauthors", allAuthors);

        return "book_edit";
    }

    @RequestMapping(value = "/books/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book")
                             Book book1, BindingResult result) {

        Book theBook = bookService.findById(book1.getId());

        Set<Author> updatedAuthors = new HashSet<Author>();
        for (Long id : book1.getAuthorids()) {
            Author author = authorService.findById(id);
            updatedAuthors.add(author);
        }

        theBook.setAuthors(updatedAuthors);

        bookService.updateBook(theBook);

        return "redirect:/books";
    }

    @RequestMapping(value = "/books/{authorId}", method = RequestMethod.GET)
    public String listBooksForAuthor(ModelMap model, @PathVariable("authorId") Long authorId) {

        model.addAttribute("author", authorService.findById(authorId));

        return "author_books";
    }
}
