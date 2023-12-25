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
public class AnimeFilmModel {
    
    private Integer animeFilmId;

    private String animeFilmTitle;

    private String animeFilmImg;

    private String animeFilmStatus;

}
