package com.sergiomercado.projects.MovieManagement.persistence.repository;

import com.sergiomercado.projects.MovieManagement.persistence.entity.Movie;
import com.sergiomercado.projects.MovieManagement.util.MovieGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieCrudRepository extends JpaRepository<Movie, Long> {
    List<Movie> findByTitleContaining(String title);
    List<Movie> findByGenre(MovieGenre genre);
    List<Movie> findByGenreAndTitleContaining(MovieGenre genre, String title);
}
