package gusta.miithersz.geekcave.models.anime;

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
public class AnimeXAnimeGenreModel {
    
    private AnimeModel anime;

    private AnimeGenreModel animeGenre;
    
}
