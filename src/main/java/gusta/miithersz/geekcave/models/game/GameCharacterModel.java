package gusta.miithersz.geekcave.models.game;

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

@Entity(name = "GameCharacter")
@Table(name = "game_character")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "gameCharacterId")
public class GameCharacterModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_character_id")
    private Long gameCharacterId;

    @ManyToOne
    @JoinColumn(name = "fk_game_id", referencedColumnName = "game_id")
    private GameModel game;

    private String gameCharacterName;

    private String gameCharacterImg;

}
