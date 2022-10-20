package com.binar.app.repository;

import com.binar.app.model.Films;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Films, Long> {

}
