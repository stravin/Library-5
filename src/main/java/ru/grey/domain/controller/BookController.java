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

    @RequestMapping(value = "/books/{authorId}", method = RequestMethod.GET)
    public String listBooks(ModelMap model, @PathVariable("authorId") Long authorId) {

        model.addAttribute("author", authorService.findById(authorId));
        model.addAttribute("book", new Book());
        //model.addAttribute("bookList", bookService.findAll());
        model.addAttribute("genreList", genreService.findAll());

        return "books";
    }

    @RequestMapping(value = "/books/addbook", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book")
                          Book book, BindingResult result) {

        System.out.println(book);

        bookService.addBook(book);

        return "redirect:/authors";
    }
}
