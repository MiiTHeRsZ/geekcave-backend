package gusta.miithersz.geekcave.models.manga;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaModel;
import gusta.miithersz.geekcave.models.FranchiseModel;
import gusta.miithersz.geekcave.utils.enumerated.manga.MangaGenre;
import gusta.miithersz.geekcave.utils.enumerated.manga.MangaType;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Manga")
@Table(name = "manga")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "mangaId")
public class MangaModel {

    public MangaModel(DTOMangaModel manga) {
        this.mangaId = manga.mangaId();
        this.mangaPin = manga.mangaPin();
        this.franchise = new FranchiseModel(manga.franchise());
        this.mangaTitle = new MangaTitleModel(manga.mangaTitle());
        this.mangaType = manga.mangaType();
        this.mangaStatus = manga.mangaStatus();
        this.mangaAuthor = manga.mangaAuthor();
        this.mangaArtist = manga.mangaArtist();
        this.mangaSynopsis = manga.mangaSynopsis();
        this.mangaGenres = manga.mangaGenres();
        this.mangaCharacters = manga.mangaCharacters();
        this.mangaCovers = manga.mangaCovers();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_id")
    private Long mangaId;

    @Column(name = "manga_pin")
    private Boolean mangaPin;

    @ManyToOne
    @JoinColumn(name = "fk_franchise_id", referencedColumnName = "franchise_id")
    private FranchiseModel franchise;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_manga_title_id", referencedColumnName = "manga_title_id")
    private MangaTitleModel mangaTitle;

    @Column(name= "manga_tier")
    private String mangaTier;

    @Enumerated(EnumType.STRING)
    private MangaType mangaType;

    @Column(name = "manga_chapters")
    private Integer mangaChapters;

    @Column(name = "manga_status")
    private String mangaStatus;

    @Column(name = "manga_author")
    private String mangaAuthor;

    @Column(name = "manga_artist")
    private String mangaArtist;

    @Column(name = "manga_synopsis")
    private String mangaSynopsis;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "manga_genre", joinColumns = @JoinColumn(name = "fk_manga_id", referencedColumnName = "manga_id"))
    @Column(name = "manga_genre_name")
    private Set<MangaGenre> mangaGenres;

    @JsonIgnoreProperties("manga")
    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL)
    private Set<MangaCharacterModel> mangaCharacters;

    @JsonIgnoreProperties("manga")
    @OneToMany(mappedBy = "manga", cascade = CascadeType.ALL)
    private Set<MangaCoverModel> mangaCovers;

}
