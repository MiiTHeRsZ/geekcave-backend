package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaModel;
import jakarta.persistence.Entity;
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
        this.mangaId = manga.mangaId() != null ? manga.mangaId() : null;
        this.mangaPin = manga.mangaPin();
        this.mangaTitle = new MangaTitleModel(manga.mangaTitle());
        this.mangaType = manga.mangaType();
        this.mangaStatus = manga.mangaStatus();
        this.mangaAuthor = manga.mangaAuthor();
        this.mangaArtist = manga.mangaArtist();
        this.mangaSynopsis = manga.mangaSynopsis();
    }

    private Long mangaId;

    private Boolean mangaPin;

    private MangaTitleModel mangaTitle;

    // ! Enum
    private String mangaType;

    private Integer mangaChapters;

    private String mangaStatus;

    private String mangaAuthor;

    private String mangaArtist;

    private String mangaSynopsis;

}
