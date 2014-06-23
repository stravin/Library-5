package ru.grey.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.grey.domain.model.Book;
import ru.grey.domain.service.AuthorService;
import ru.grey.domain.service.BookService;
import ru.grey.domain.service.GenreService;

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

        return "book_edit";
    }

    @RequestMapping(value = "/books/update", method = RequestMethod.POST)
    public String updateBook(@ModelAttribute("book")
                               Book book, BindingResult result) {

        bookService.updateBook(book);

        return "redirect:/books";
    }

    @RequestMapping(value = "/books/{authorId}", method = RequestMethod.GET)
    public String listBooksForAuthor(ModelMap model, @PathVariable("authorId") Long authorId) {

        model.addAttribute("author", authorService.findById(authorId));

        return "author_books";
    }
}
