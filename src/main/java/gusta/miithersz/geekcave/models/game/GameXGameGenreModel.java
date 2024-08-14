package gusta.miithersz.geekcave.models.game;

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
public class GameXGameGenreModel {

    private Long gameXGameGenreId;
    
    private GameModel game;

    private GameGenreModel gameGenre;

}
