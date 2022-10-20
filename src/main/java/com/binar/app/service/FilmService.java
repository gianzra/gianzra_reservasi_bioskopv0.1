package com.binar.app.service;

import com.binar.app.dto.FilmDTO;
import com.binar.app.model.Films;

import java.util.List;

public interface FilmService {

    Films create(Films films);
    Films update(Long film_code, Films films);
    Boolean delete(Long film_code);
    List<Films> findAll();
    Films findById(Long film_code);

    FilmDTO mapToDto(Films films);
    Films mapToEntity(FilmDTO filmDTO);

}
