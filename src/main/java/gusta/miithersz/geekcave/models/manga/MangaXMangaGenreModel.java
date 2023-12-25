package gusta.miithersz.geekcave.models.manga;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MangaXMangaGenreModel {
    
    private MangaModel manga;

    private MangaGenreModel mangaGenre;
    
}
