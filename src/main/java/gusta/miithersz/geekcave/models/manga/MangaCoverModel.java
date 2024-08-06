package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaCoverModel;
import jakarta.persistence.Entity;
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
        this.mangaCoverId = cover.mangaCoverId() != null ? cover.mangaCoverId() : null;
        this.manga = new MangaModel(cover.manga());
        this.mangaCoverVol = cover.mangaCoverVol();
        this.mangaCoverImg = cover.mangaCoverImg();
    }

    private Long mangaCoverId;

    @ManyToOne
    @JoinColumn(name = "fk_manga_id", referencedColumnName = "manga_id")
    private MangaModel manga;

    private Integer mangaCoverVol;

    private String mangaCoverImg;

}
