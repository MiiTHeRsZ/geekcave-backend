package gusta.miithersz.geekcave.models.manga;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaCoverModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "MangaCover")
@Table(name = "manga_table")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "mangaCoverId")
public class MangaCoverModel {

    public MangaCoverModel(DTOMangaCoverModel cover) {
        this.mangaCoverId = cover.mangaCoverId();
        this.manga = new MangaModel(cover.manga());
        this.mangaCoverVol = cover.mangaCoverVol();
        this.mangaCoverImg = cover.mangaCoverImg();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_cover_id")
    private Long mangaCoverId;

    @JsonIgnoreProperties({
            "mangaPin",
            "mangaTier",
            "mangaType",
            "mangaChapters",
            "mangaStatus",
            "mangaSynopsis",
            "mangaGenres",
            "mangaCharacters",
            "mangaCovers" })
    @ManyToOne
    @JoinColumn(name = "fk_manga_id", referencedColumnName = "manga_id")
    private MangaModel manga;

    @Column(name = "manga_cover_vol")
    private Integer mangaCoverVol;

    @Column(name = "manga_cover_img")
    private String mangaCoverImg;

}
