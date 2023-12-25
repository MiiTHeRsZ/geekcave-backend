package gusta.miithersz.geekcave.models.animeFilm;

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
public class AnimeFilmXAnimeFilmGenreModel {
    
    private AnimeFilmModel animeFilm;

    private AnimeFilmGenreModel animeFilmGenre;

}
