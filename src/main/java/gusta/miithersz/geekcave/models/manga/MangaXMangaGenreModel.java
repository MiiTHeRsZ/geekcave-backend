package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaXMangaGenreModel;
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

@Entity(name = "MangaXMangaGenre")
@Table(name = "manga_x_manga_genre")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "mangaXMangaGenreModelId")
public class MangaXMangaGenreModel {

    public MangaXMangaGenreModel(DTOMangaXMangaGenreModel mangaXGenre) {
        this.mangaXMangaGenreModelId = mangaXGenre.mangaXMangaGenreModelId();
        this.manga = new MangaModel(mangaXGenre.manga());
        this.mangaGenre = new MangaGenreModel(mangaXGenre.mangaGenre());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_x_manga_genre_id")
    private Long mangaXMangaGenreModelId;
    
    @OneToOne
    @JoinColumn(name = "fk_manga_id", referencedColumnName = "manga_id")
    private MangaModel manga;

    @OneToOne
    @JoinColumn(name = "fk_manga_genre_id", referencedColumnName = "manga_genre_id")
    private MangaGenreModel mangaGenre;
    
}
