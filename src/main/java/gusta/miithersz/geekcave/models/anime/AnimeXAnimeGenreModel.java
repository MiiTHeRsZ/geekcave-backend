package gusta.miithersz.geekcave.models.anime;

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

    public AnimeXAnimeGenreModel(DTOAnimeXAnimeGenreModel animeXAnimeGenre) {
        this(null, new AnimeModel(animeXAnimeGenre.anime()), new AnimeGenreModel(animeXAnimeGenre.animeGenre()));
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_x_anime_genre_id")
    private Long animeXAnimeGenreId;

    @OneToOne
    @JoinColumn(name = "fk_anime_id", referencedColumnName = "anime_id")
    private AnimeModel anime;

    @OneToOne
    @JoinColumn(name = "fk_anime_genre_id", referencedColumnName = "anime_genre_id")
    private AnimeGenreModel animeGenre;

}
