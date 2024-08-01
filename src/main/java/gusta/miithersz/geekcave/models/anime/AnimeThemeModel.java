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
        this(null, new AnimeModel(theme.anime()), theme.animeThemeSong(), theme.animeThemeType());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_theme_id")
    private Long animeThemeId;

    @OneToOne
    @JoinColumn(name = "fk_anime_id", referencedColumnName = "anime_id")
    private AnimeModel anime;

    @Column(name = "anime_theme_song")
    private String animeThemeSong;

    // ! Maybe ENUM ?
    @Column(name = "anime_theme_type")
    private String animeThemeType;

}
