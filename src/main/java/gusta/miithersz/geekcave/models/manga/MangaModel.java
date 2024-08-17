package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaModel;
import gusta.miithersz.geekcave.utils.enumerated.manga.MangaType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
        this.mangaTitle = new MangaTitleModel(manga.mangaTitle());
        this.mangaType = manga.mangaType();
        this.mangaStatus = manga.mangaStatus();
        this.mangaAuthor = manga.mangaAuthor();
        this.mangaArtist = manga.mangaArtist();
        this.mangaSynopsis = manga.mangaSynopsis();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_id")
    private Long mangaId;

    private Boolean mangaPin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_manga_title_id", referencedColumnName = "manga_title_id")
    private MangaTitleModel mangaTitle;

    @Enumerated(EnumType.STRING)
    private MangaType mangaType;

    private Integer mangaChapters;

    private String mangaStatus;

    private String mangaAuthor;

    private String mangaArtist;

    private String mangaSynopsis;

}
