package ru.grey.domain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.grey.domain.model.Genre;
import ru.grey.domain.service.GenreService;

/**
 * Created by stravin on 19.06.2014.
 */
@Controller
public class GenreController {

    @Autowired
    private GenreService genreService;

    @RequestMapping(value = "/genres", method = RequestMethod.GET)
    public String listGenres(ModelMap model) {

        model.addAttribute("genre", new Genre());
        model.addAttribute("genreList", genreService.findAll());
        return "genres";
    }

    @RequestMapping(value = "/addgenre", method = RequestMethod.POST)
    public String addGenre(@ModelAttribute("genre")
                             Genre genre, BindingResult result) {

        genreService.addGenre(genre);

        return "redirect:/genres";
    }
}
