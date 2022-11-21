package com.binar.film.controller;


import com.binar.film.dto.FilmDTO;
import com.binar.film.model.Films;
import com.binar.film.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    FilmService filmService;

    @PostMapping("/create")
   // @CrossOrigin( origins = "https://gianzrareservasibioskop-production.up.railway.app/films/create")
    public FilmDTO create(@RequestBody FilmDTO request) {
        final Films film = filmService.mapToEntity(request);
        final Films result = filmService.create(film);
        return filmService.mapToDto(result);
    }

    @PutMapping("update/{film_code}")
    //@CrossOrigin( origins = "https://gianzrareservasibioskop-production.up.railway.app/films/update")
    public FilmDTO update(@PathVariable Long filmCode, @RequestBody FilmDTO request) {
        final Films film = filmService.mapToEntity(request);
        final Films result = filmService.update(filmCode, film);
        return filmService.mapToDto(result);
    }

    @GetMapping("/all")
   // @CrossOrigin( origins = "https://gianzrareservasibioskop-production.up.railway.app/films/all")
    public List<FilmDTO> findAll() {
        return filmService.findAll().stream().map(film -> filmService.mapToDto(film)).toList();
    }

    @DeleteMapping("/delete/{film_code}")
    public Boolean delete(@PathVariable Long filmCode) {
        return filmService.delete(filmCode);
    }

}
