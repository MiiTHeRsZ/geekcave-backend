package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaGenreModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "MangaGenre")
@Table(name = "manga_genre")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "mangaGenreId")
public class MangaGenreModel {

    public MangaGenreModel(DTOMangaGenreModel genre) {
        this.mangaGenreId = genre.mangaGenreId() != null ? genre.mangaGenreId() : null;
        this.mangaGenreName = genre.mangaGenreName();
    }

    private Long mangaGenreId;

    private String mangaGenreName;

}
