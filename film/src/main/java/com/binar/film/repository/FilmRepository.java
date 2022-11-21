package com.binar.film.repository;


import com.binar.film.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Films, Long> {

}
