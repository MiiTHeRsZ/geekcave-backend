package gusta.miithersz.geekcave.models.game;

import java.util.Date;

import gusta.miithersz.geekcave.dto.requests.game.DTOGameModel;
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
        this.gameId = game.gameId();
        this.gameTitle = game.gameTitle();
        this.gameImg = game.gameImg();
        this.gameDeveloper = new GameDeveloperModel(game.gameDeveloper());
        this.gameReleased = game.gameReleased();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    private String gameTitle;

    private String gameImg;

    @OneToOne
    @JoinColumn(name = "fk_game_developer_id", referencedColumnName = "game_developer_id")
    private GameDeveloperModel gameDeveloper;

    private Date gameReleased;

}
