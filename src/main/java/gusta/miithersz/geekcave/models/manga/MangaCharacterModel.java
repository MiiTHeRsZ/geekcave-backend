package gusta.miithersz.geekcave.models.manga;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaCharacterModel;
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

@Entity(name = "MangaCharacter")
@Table(name = "manga_character")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "mangaCharacterId")
public class MangaCharacterModel {
    
    public MangaCharacterModel(DTOMangaCharacterModel character) {
        this.mangaCharacterId = character.mangaCharacterId() != null ? character.mangaCharacterId() : null;
        this.manga = new MangaModel(character.manga());
        this.mangaCharacterName = character.mangaCharacterName();
        this.mangaCharacterImg = character.mangaCharacterImg();
    }

    private Long mangaCharacterId;

    @ManyToOne
    @JoinColumn(name = "fk_manga_id", referencedColumnName = "manga_id")
    private MangaModel manga;

    private String mangaCharacterName;

    private String mangaCharacterImg;
}
