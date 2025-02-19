package com.sergiomercado.projects.MovieManagement.service;

import com.sergiomercado.projects.MovieManagement.persistence.entity.Movie;
import com.sergiomercado.projects.MovieManagement.util.MovieGenre;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    List<Movie> findAllByTitle(String title);
    List<Movie> findAllByGenre(MovieGenre genre);
    List<Movie> findAllByGenreAndTitle(MovieGenre genre, String title);
    Movie findOneById(Long id);
    Movie createOne(Movie movie);
    Movie updateOneById(Long id, Movie movie);
    void deleteOneById(Long id);
}
