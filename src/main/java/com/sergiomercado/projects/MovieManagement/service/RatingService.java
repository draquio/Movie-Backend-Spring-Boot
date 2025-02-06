package com.sergiomercado.projects.MovieManagement.service;

import com.sergiomercado.projects.MovieManagement.persistence.entity.Rating;

import java.util.List;

public interface RatingService {
    List<Rating> findAll();
    List<Rating> findAllByMovieId(Long movieId);
    List<Rating> findAllByUsername(String Username);
    Rating findOneById(Long id);
    Rating createOne(Rating rating);
    Rating updateOneById(Long id, Rating rating);
    void deleteOneById(Long id);
}
