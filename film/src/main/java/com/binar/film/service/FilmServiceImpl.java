package com.binar.film.service;


import com.binar.film.dto.FilmDTO;
import com.binar.film.model.Films;
import com.binar.film.repository.FilmRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {

    private static final Logger logger = LoggerFactory.getLogger(FilmServiceImpl.class);
    @Autowired
    FilmRepository filmRepository;

    @Override
    public Films create(Films films) {
        return filmRepository.save(films);
    }

    @Override
    public Films update(Long filmCode, Films films) {
        Films result = findById(filmCode);
        if(result != null) {
            logger.info("Data film tersedia");
            result.setFilmCode(filmCode);
            result.setFilmName(films.getFilmName());
            result.setIsShowing(films.getIsShowing());
            filmRepository.save(films);
        }else {
            logger.error("Data film tidak tersedia");
        }
        return result;
    }

    @Override
    public Boolean delete(Long filmCode) {
        final Films result = findById(filmCode);
        if (result != null) {
            logger.info("Menghapus data film dari database");
            // hard delete
            filmRepository.deleteById(filmCode);
            return true;
        }else {
            logger.error("Data film tidak tersedia");
        }
        return false;
    }

    @Override
    public List<Films> findAll() {
        logger.info("Mengambil data film dari database");
        return filmRepository.findAll();
    }

    @Override
    public Films findById(Long filmCode) {
        Optional<Films> result = filmRepository.findById(filmCode);
        if(result.isPresent()) {
            logger.info("Data film tersedia");
            return result.get();
        } else {
            logger.error("Data film tidak dimasukkan");
        }
        return null;
    }

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public FilmDTO mapToDto(Films films) {
        return mapper.convertValue(films, FilmDTO.class);
    }

    @Override
    public Films mapToEntity(FilmDTO filmDTO) {
        return mapper.convertValue(filmDTO, Films.class);
    }

}
