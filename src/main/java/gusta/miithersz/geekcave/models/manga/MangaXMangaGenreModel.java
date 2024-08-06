package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaXMangaGenreModel;
import jakarta.persistence.Entity;
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

    public MangaXMangaGenreModel(DTOMangaXMangaGenreModel mxmg) {
        this.mangaXMangaGenreModelId = mxmg.mangaXMangaGenreModelId() != null ? mxmg.mangaXMangaGenreModelId() : null;
        this.manga = new MangaModel(mxmg.manga());
        this.mangaGenre = new MangaGenreModel(mxmg.mangaGenre());
    }

    private Long mangaXMangaGenreModelId;
    
    private MangaModel manga;

    private MangaGenreModel mangaGenre;
    
}
