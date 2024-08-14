package gusta.miithersz.geekcave.models.game;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "GameGenre")
@Table(name = "game_genre")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "gameGenreId")
public class GameGenreModel {
    
    private Long gameGenreId;

    private String gameGenreName;

}
