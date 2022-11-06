package com.binar.app.service;

import com.binar.app.dto.FilmDTO;
import com.binar.app.model.Films;

import java.util.List;

public interface FilmService {

    Films create(Films films);
    Films update(Long filmCode, Films films);
    Boolean delete(Long filmCode);
    List<Films> findAll();
    Films findById(Long filmCode);

    FilmDTO mapToDto(Films films);
    Films mapToEntity(FilmDTO filmDTO);

}
