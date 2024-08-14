package gusta.miithersz.geekcave.models.game;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
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
    
    private Long gameCharacterId;

    private GameModel game;

    private String gameCharacterName;

    private String gameCharacterImg;

}
