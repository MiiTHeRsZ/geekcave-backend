package gusta.miithersz.geekcave.models.film;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class FilmXFilmGenreModel {
    
    private FilmModel film;

    private FilmGenreModel filmGenreId;

}
