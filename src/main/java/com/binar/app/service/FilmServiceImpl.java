package com.binar.app.service;

import com.binar.app.dto.FilmDTO;
import com.binar.app.model.Films;
import com.binar.app.repository.FilmRepository;
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

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    FilmRepository filmRepository;

    @Override
    public Films create(Films films) {
        final Films result = filmRepository.save(films);
        return result;
    }

    @Override
    public Films update(Long film_code, Films films) {
        Films result = findById(film_code);
        if(result != null) {
            result.setFilm_code(film_code);
            result.setFilm_name(films.getFilm_name());
            result.setIs_showing(films.getIs_showing());
            filmRepository.save(films);
        }
        return null;
    }

    @Override
    public Boolean delete(Long film_code) {
        final Films result = findById(film_code);
        if (result != null) {
            // hard delete
            filmRepository.deleteById(film_code);
            return true;
        }
        return false;
    }

    @Override
    public List<Films> findAll() {
        logger.info("Fetching data user from database");
        return filmRepository.findAll();
    }

    @Override
    public Films findById(Long film_code) {
        Optional<Films> result = filmRepository.findById(film_code);
        if(result.isPresent()) {
            logger.info("Fetching data user from database");
            return result.get();
        } else {
            logger.error("Data user not found");
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
