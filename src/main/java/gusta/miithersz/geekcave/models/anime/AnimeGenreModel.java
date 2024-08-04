package gusta.miithersz.geekcave.models.anime;

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeGenreModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "AnimeGenre")
@Table(name = "anime_genre")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "animeGenreId")
public class AnimeGenreModel {

    public AnimeGenreModel(DTOAnimeGenreModel animeGenre) {
        this(animeGenre.animeGenreId() != null ? animeGenre.animeGenreId() : null, animeGenre.animeGenreName());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_genre_id")
    private Long animeGenreId;

    @Column(name = "anime_genre_name")
    private String animeGenreName;
    
}
