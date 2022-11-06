package filmTest;

import com.binar.app.model.Films;
import com.binar.app.repository.FilmRepository;
import com.binar.app.service.FilmServiceImpl;
import dataTest.DataFilmTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

class FilmServiceImplTest {
    @InjectMocks
    FilmServiceImpl filmService;

    @Mock
    FilmRepository filmRepository;

    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Mengambil Film tidak dapat ditemukan")
    void MockTestGetFilmNotFound() {
        Exception e = Assertions.assertThrows(Exception.class, () -> {
            Mockito.verify(filmService.findById(Long.valueOf("NOT FOUND")));
        });
        Assertions.assertNotNull(e.getMessage());
    }

    @Test
    @DisplayName("Mengambil semua Film Berhasil")
    void MockTestGetAllFilmSuccess() {
        List<Films> filmEntities = DataFilmTest.getDataFilm();
        Mockito.when(filmRepository.findAll()).thenReturn(filmEntities);

        var actualValue = filmService.findAll();
        Assertions.assertEquals(1, actualValue.size());
        Assertions.assertEquals("Spiderman", actualValue.get(0).getFilmName());

    }

    @Test
    @DisplayName("Membuat Film Berhasil")
    void MockTestCreateFilm() {
        Films film = new Films();
        film.setFilmCode(Long.valueOf("1"));
        film.setFilmName("Spiderman");
        film.setIsShowing(true);
        Mockito.when(filmRepository.save(film)).thenReturn(film);
        Assertions.assertEquals(film, filmService.create(film));
    }

    @Test
    @DisplayName("MengUpdate Film Berhasil")
    void MockTestUpdateFilm() {
        Films film = new Films();
        film.setFilmCode(Long.valueOf("1"));
        film.setFilmName("Spiderman");
        film.setIsShowing(true);

        Mockito.when(filmRepository.findById(1L)).thenReturn(Optional.of(film));
        Mockito.when(filmRepository.save(film)).thenReturn(film);

        var actualValue = filmService.update(1L, film);
        Assertions.assertEquals(1L, actualValue.getFilmCode());
        Assertions.assertEquals("Spiderman", actualValue.getFilmName());
        Assertions.assertNotNull(actualValue);
    }

    @Test
    @DisplayName("Menghapus Film Berhasil")
    void MockTestDeleteFilm() {
        Films film = new Films();
        film.setFilmCode(Long.valueOf("1"));
        film.setFilmName("Spiderman");
        film.setIsShowing(true);

        Mockito.when(filmRepository.findById(1L)).thenReturn(Optional.of(film));
        Mockito.doNothing().when(filmRepository).deleteById(1L);
        filmService.delete(1L);
        Mockito.verify(filmRepository).deleteById(1L);

    }

    @Test
    @DisplayName("Mengambil Film ById")
    void MockTestFilmFindById() {
        Films film = new Films();
        film.setFilmCode(Long.valueOf("1"));
        film.setFilmName("Spiderman");
        film.setIsShowing(true);

        Mockito.when(filmRepository.findById(Long.valueOf("1"))).thenReturn(Optional.of(film));

        var actualValue = filmService.update(1L, film);
        Assertions.assertEquals(1L, actualValue.getFilmCode());
        Assertions.assertEquals("Spiderman", actualValue.getFilmName());
        Assertions.assertNotNull(actualValue);

    }


    @Test
    @DisplayName("Mengatur Jadwal Film")
    void MockTestSetSchedules() {
        Films film = new Films();
        film.setFilmCode(Long.valueOf("1"));
        film.setFilmName("Spiderman");
        film.setIsShowing(true);

        Mockito.when(filmRepository.findById(Long.valueOf("1"))).thenReturn(Optional.of(film));
        Mockito.when(filmRepository.save(film)).thenReturn(film);
        Assertions.assertEquals(film, filmService.create(film));
    }
}

