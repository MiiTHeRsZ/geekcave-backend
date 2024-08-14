package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaTitleModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "MangaTitle")
@Table(name = "manga_title")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "mangaTitleId")
public class MangaTitleModel {

    public MangaTitleModel(DTOMangaTitleModel mangaTitle) {
        this.mangaTitleId = mangaTitle.mangaTitleId() != null ? mangaTitle.mangaTitleId() : null;
        this.mangaTitleDefault = mangaTitle.mangaTitleDefault();
        this.mangaTitleEnglish = mangaTitle.mangaTitleEnglish();
        this.mangaTitleJapanese = mangaTitle.mangaTitleJapanese();
        this.mangaTitleKorean = mangaTitle.mangaTitleKorean();
        this.mangaTitleSynonyms = mangaTitle.mangaTitleSynonyms();
    }

    private Long mangaTitleId;

    private String mangaTitleDefault;

    private String mangaTitleEnglish;

    private String mangaTitleJapanese;

    private String mangaTitleKorean;

    private String mangaTitleSynonyms;

}
