package com.binar.app.controller;

import com.binar.app.dto.FilmDTO;
import com.binar.app.model.Films;
import com.binar.app.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    FilmService filmService;

    @PostMapping("/create")
    public FilmDTO create(@RequestBody FilmDTO request) {
        final Films film = filmService.mapToEntity(request);
        final Films result = filmService.create(film);
        return filmService.mapToDto(result);
    }

    @PutMapping("update/{film_code}")
    public FilmDTO update(@PathVariable Long film_code, @RequestBody FilmDTO request) {
        final Films film = filmService.mapToEntity(request);
        final Films result = filmService.update(film_code, film);
        return filmService.mapToDto(result);
    }

    @GetMapping("/all")
    public List<FilmDTO> findAll() {
        return filmService.findAll().stream().map(film -> filmService.mapToDto(film)).collect(Collectors.toList());
    }

    @DeleteMapping("/delete/{film_code}")
    public Boolean delete(@PathVariable Long film_code) {
        return filmService.delete(film_code);
    }

}
