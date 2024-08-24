package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaTitleModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public MangaTitleModel(DTOMangaTitleModel title) {
        this.mangaTitleId = title.mangaTitleId();
        this.mangaTitleDefault = title.mangaTitleDefault();
        this.mangaTitleEnglish = title.mangaTitleEnglish();
        this.mangaTitleJapanese = title.mangaTitleJapanese();
        this.mangaTitleKorean = title.mangaTitleKorean();
        this.mangaTitleSynonyms = title.mangaTitleSynonyms();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_title_id")
    private Long mangaTitleId;

    @Column(name = "manga_title_default")
    private String mangaTitleDefault;

    @Column(name = "manga_title_english")
    private String mangaTitleEnglish;

    @Column(name = "manga_title_japanese")
    private String mangaTitleJapanese;

    @Column(name = "manga_title_korean")
    private String mangaTitleKorean;

    @Column(name = "manga_title_synonyms")
    private String mangaTitleSynonyms;

}
