package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaTitleModel;
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
public class MangaTitleModel {

    public MangaTitleModel(DTOMangaTitleModel mangaTitle) {
        this.mangaTitleId = mangaTitle.mangaTitleId() != null ? mangaTitle.mangaTitleId() : null;
        this.mangaTitleDefault = mangaTitle.mangaTitleDefault();
        this.mangaTitleEnglish = mangaTitle.mangaTitleEnglish();
        this.mangaTitleJapanese = mangaTitle.mangaTitleJapanese();
        this.mangaTitleSynonyms = mangaTitle.mangaTitleSynonyms();
    }

    private Long mangaTitleId;

    private String mangaTitleDefault;

    private String mangaTitleEnglish;

    private String mangaTitleJapanese;

    private String mangaTitleSynonyms;

}
