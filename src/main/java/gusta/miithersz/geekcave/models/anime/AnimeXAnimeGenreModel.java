package gusta.miithersz.geekcave.models.anime;

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeXAnimeGenreModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "AnimeXAnimeGenre")
@Table(name = "anime_x_anime_genre")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "animeXAnimeGenreId")
public class AnimeXAnimeGenreModel {

    public AnimeXAnimeGenreModel(DTOAnimeXAnimeGenreModel animeXGenre) {
        this(animeXGenre.animeXAnimeGenreId(), new AnimeModel(animeXGenre.anime()), new AnimeGenreModel(animeXGenre.animeGenre()));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_x_anime_genre_id")
    private Long animeXAnimeGenreId;

    // ? maybe this should change
    @OneToOne
    @JoinColumn(name = "fk_anime_id", referencedColumnName = "anime_id")
    private AnimeModel anime;

    @OneToOne
    @JoinColumn(name = "fk_anime_genre_id", referencedColumnName = "anime_genre_id")
    private AnimeGenreModel animeGenre;

}
