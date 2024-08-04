package gusta.miithersz.geekcave.models.anime;

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeCharacterModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "AnimeCharacter")
@Table(name = "anime_character")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "animeCharacterId")
public class AnimeCharacterModel {

    public AnimeCharacterModel(DTOAnimeCharacterModel animeCharacter) {
        this(null, new AnimeModel(animeCharacter.anime()), animeCharacter.animeCharacterName(), animeCharacter.animeCharacterImg());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_character_id")
    private Long animeCharacterId;

    @OneToOne
    @JoinColumn(name = "fk_anime_id", referencedColumnName = "anime_id")
    private AnimeModel anime;

    @Column(name = "anime_character_name")
    private String animeCharacterName;

    @Column(name = "anime_character_img")
    private String animeCharacterImg;
}
