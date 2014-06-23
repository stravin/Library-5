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
import ru.grey.domain.service.AuthorService;

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

        return "/authors";
    }

    @RequestMapping(value = "/authors/add", method = RequestMethod.POST)
    public String addAuthor(@ModelAttribute("author")
                             Author author, BindingResult result) {

        authorService.addAuthor(author);

        return "/authors";
    }

    @RequestMapping(value = "/authors/edit/{authorId}", method = RequestMethod.GET)
    public String updateAuthorForm(ModelMap model, @PathVariable("authorId") Long authorId) {

        model.addAttribute("author", authorService.findById(authorId));

        return "/author_edit";
    }

    @RequestMapping(value = "/authors/update", method = RequestMethod.POST)
    public String updateAuthor(@ModelAttribute("author")
                            Author author, BindingResult result) {

        authorService.updateAuthor(author);

        return "redirect:/authors";
    }
}
