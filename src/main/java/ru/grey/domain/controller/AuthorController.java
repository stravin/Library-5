package ru.grey.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ru.grey.domain.model.Author;
import ru.grey.domain.model.Book;
import ru.grey.domain.service.AuthorService;
import ru.grey.domain.service.BookService;

/**
 * Created by stravin on 19.06.2014.
 */
@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String listAuthors(ModelMap model) {

        model.addAttribute("author", new Author());
        model.addAttribute("authorList", authorService.findAll());
        return "authors";
    }

    @RequestMapping(value = "/addauthor", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author")
                             Author author, BindingResult result) {

        authorService.addAuthor(author);

        return "redirect:/authors";
    }
}
