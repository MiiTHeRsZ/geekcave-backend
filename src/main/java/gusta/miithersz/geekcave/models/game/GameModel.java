package gusta.miithersz.geekcave.models.game;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GameModel {
    
    private Integer gameId;

    private String gameTitle;

    private String gameImg;

    private GameDeveloperModel gameDeveloper;

    private Date gameReleased;

}
