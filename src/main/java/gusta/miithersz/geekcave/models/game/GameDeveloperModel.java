package gusta.miithersz.geekcave.models.game;

import gusta.miithersz.geekcave.dto.requests.game.DTOGameDeveloperModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "GameDeveloper")
@Table(name = "game_developer")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "gameDeveloperId")
public class GameDeveloperModel {

    public GameDeveloperModel(DTOGameDeveloperModel gameDeveloper) {
        this.gameDeveloperId = gameDeveloper.gameDeveloperId() != null ? gameDeveloper.gameDeveloperId() : null;
        this.gameDeveloperName = gameDeveloper.gameDeveloperName();
    }

    private Long gameDeveloperId;

    private String gameDeveloperName;

}
