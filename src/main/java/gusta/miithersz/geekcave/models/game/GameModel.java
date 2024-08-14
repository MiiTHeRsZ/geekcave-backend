package gusta.miithersz.geekcave.models.game;

import java.util.Date;

import gusta.miithersz.geekcave.dto.requests.game.DTOGameModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Game")
@Table(name = "game")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "gameId")
public class GameModel {
    
    public GameModel(DTOGameModel game) {
        this.gameId = game.gameId() != null ? game.gameId() : null;
        this.gameTitle = game.gameTitle();
        this.gameImg = game.gameImg();
        this.gameDeveloper = new GameDeveloperModel(game.gameDeveloper());
        this.gameReleased = game.gameReleased();
    }

    private Long gameId;

    private String gameTitle;

    private String gameImg;

    private GameDeveloperModel gameDeveloper;

    private Date gameReleased;

}
