package gusta.miithersz.geekcave.models.game;

import gusta.miithersz.geekcave.dto.requests.game.DTOGameDeveloperModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

    public GameDeveloperModel(DTOGameDeveloperModel developer) {
        this.gameDeveloperId = developer.gameDeveloperId();
        this.gameDeveloperName = developer.gameDeveloperName();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_developer_id")
    private Long gameDeveloperId;

    @Column(name = "game_developer_name")
    private String gameDeveloperName;

}
