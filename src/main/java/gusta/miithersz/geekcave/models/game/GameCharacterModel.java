package gusta.miithersz.geekcave.models.game;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gusta.miithersz.geekcave.dto.requests.game.DTOGameCharacterModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "GameCharacter")
@Table(name = "game_character")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "gameCharacterId")
public class GameCharacterModel {

    public GameCharacterModel(@Valid DTOGameCharacterModel character) {
        this.gameCharacterId = character.gameCharacterId();
        this.game = new GameModel(character.game());
        this.gameCharacterName = character.gameCharacterName();
        this.gameCharacterImg = character.gameCharacterImg();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_character_id")
    private Long gameCharacterId;

    @JsonIgnoreProperties({
            "gamePin",
            "gameTier",
            "gameDeveloper",
            "gameReleased",
            "gamePrequel",
            "gameSequel",
            "gameCharacters",
            "gameGenres",
            "gameFeatures" })
    @ManyToOne
    @JoinColumn(name = "fk_game_id", referencedColumnName = "game_id")
    private GameModel game;

    @Column(name = "game_character_name")
    private String gameCharacterName;

    @Column(name = "game_character_img")
    private String gameCharacterImg;

}
