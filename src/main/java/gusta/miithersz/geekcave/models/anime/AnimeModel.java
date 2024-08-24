package gusta.miithersz.geekcave.models.anime;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeModel;
import gusta.miithersz.geekcave.utils.enumerated.anime.AnimeGenre;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Anime")
@Table(name = "anime")
// * @Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "animeId")
public class AnimeModel {

    public AnimeModel(@Valid DTOAnimeModel anime) {
        this.animeId = anime.animeId();
        this.animePin = anime.animePin();
        this.animeTitle = new AnimeTitleModel(anime.animeTitle());
        this.animeTier = anime.animeTier();
        this.animeImg = anime.animeImg();
        this.animeStudio = new AnimeStudioModel(anime.animeStudio());
        this.animeSessions = anime.animeSessions();
        this.animeStatus = anime.animeStatus();
        this.animeSynopsis = anime.animeSynopsis();
        this.animePrequel = anime.animePrequel();
        this.animeSequel = anime.animeSequel();
        this.animeGenres = anime.animeGenres();
        this.animeCharacters = anime.animeCharacters();
        this.animeThemes = anime.animeThemes();
    }

    // * UUID
    // ! Long to String | BigInt to Varchar
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_id")
    private Long animeId;

    @Column(name = "anime_pin")
    private Boolean animePin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_anime_title_id", referencedColumnName = "anime_title_id")
    private AnimeTitleModel animeTitle;

    @Column(name = "anime_tier")
    private String animeTier;

    // * .webp
    @Column(name = "anime_img")
    private String animeImg;

    // ! Differents temps may have many studios | @ManyToOne(mappedBy = "anime")
    @OneToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    @JoinColumn(name = "fk_anime_studio_id", referencedColumnName = "anime_studio_id")
    private AnimeStudioModel animeStudio;

    @Column(name = "anime_sessions")
    private Integer animeSessions;

    // * Completed / Ep
    @Column(name = "anime_status")
    private String animeStatus;

    @Column(name = "anime_synopsis")
    private String animeSynopsis;

    @Column(name = "anime_prequel")
    private Long animePrequel;

    @Column(name = "anime_sequel")
    private Long animeSequel;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "anime_genre", joinColumns = @JoinColumn(name = "fk_anime_id", referencedColumnName = "anime_id"))
    @Column(name = "anime_genre_name")
    private Set<AnimeGenre> animeGenres;

    @JsonIgnoreProperties("anime")
    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL)
    private Set<AnimeCharacterModel> animeCharacters;

    @JsonIgnoreProperties("anime")
    @OneToMany(mappedBy = "anime", cascade = CascadeType.ALL)
    private Set<AnimeThemeModel> animeThemes;

}
