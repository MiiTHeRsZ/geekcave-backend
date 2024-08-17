package gusta.miithersz.geekcave.models.anime;

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeThemeModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "AnimeTheme")
@Table(name = "anime_theme")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "animeThemeId")
public class AnimeThemeModel {

    public AnimeThemeModel(DTOAnimeThemeModel theme) {
        this(theme.animeThemeId(), new AnimeModel(theme.anime()), theme.animeThemeName(), theme.animeThemeSong(), theme.animeThemeSongFull(), theme.animeThemeType());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_theme_id")
    private Long animeThemeId;

    @ManyToOne
    @JoinColumn(name = "fk_anime_id", referencedColumnName = "anime_id")
    private AnimeModel anime;

    @Column(name = "anime_theme_name")
    private String animeThemeName;

    @Column(name = "anime_theme_song")
    private String animeThemeSong;

    @Column(name = "anime_theme_song_full")
    private String animeThemeSongFull;

    // ! Maybe ENUM ?
    @Column(name = "anime_theme_type")
    private String animeThemeType;

}
