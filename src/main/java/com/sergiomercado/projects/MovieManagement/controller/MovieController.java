package com.sergiomercado.projects.MovieManagement.controller;

import ch.qos.logback.core.util.StringUtil;
import com.sergiomercado.projects.MovieManagement.persistence.entity.Movie;
import com.sergiomercado.projects.MovieManagement.service.MovieService;
import com.sergiomercado.projects.MovieManagement.util.MovieGenre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Movie> findAll(@RequestParam(required = false) String title, @RequestParam(required = false) MovieGenre genre) {
        if(StringUtils.hasText(title) && genre != null){
            return movieService.findAllByGenreAndTitle(genre, title);
        } else if(StringUtils.hasText(title)){
            return movieService.findAllByTitle(title);
        } else if(genre != null){
            return movieService.findAllByGenre(genre);
        } else {
            return movieService.findAll();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Movie findOneById(@PathVariable Long id){
        return movieService.findOneById(id);
    }
}
