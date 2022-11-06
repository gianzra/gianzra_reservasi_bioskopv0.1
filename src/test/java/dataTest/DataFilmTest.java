package dataTest;

import com.binar.app.model.Films;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataFilmTest {
    public static List<Films> getDataFilm() {
        List<Films> listFilm = new ArrayList<>();
        Films film = new Films();
        film.setFilmCode(Long.valueOf("1"));
        film.setFilmName("Spiderman");
        film.setIsShowing(true);
        listFilm.add(film);
        return listFilm;
    }
}
