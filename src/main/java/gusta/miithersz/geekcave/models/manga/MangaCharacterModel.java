package gusta.miithersz.geekcave.models.manga;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaCharacterModel;
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
        this.mangaCharacterId = character.mangaCharacterId();
        this.manga = new MangaModel(character.manga());
        this.mangaCharacterName = character.mangaCharacterName();
        this.mangaCharacterImg = character.mangaCharacterImg();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_character_id")
    private Long mangaCharacterId;

    @JsonIgnoreProperties({
            "mangaPin",
            "mangaTier",
            "mangaType",
            "mangaChapters",
            "mangaStatus",
            "mangaSynopsis",
            "mangaGenres",
            "mangaCharacters" })
    @ManyToOne
    @JoinColumn(name = "fk_manga_id", referencedColumnName = "manga_id")
    private MangaModel manga;

    @Column(name = "manga_character_name")
    private String mangaCharacterName;

    @Column(name = "manga_character_img")
    private String mangaCharacterImg;
}
