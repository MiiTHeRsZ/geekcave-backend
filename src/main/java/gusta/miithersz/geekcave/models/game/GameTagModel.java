package gusta.miithersz.geekcave.models.game;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "GameTag")
@Table(name = "game_tag")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "gameTagId")
public class GameTagModel {
    
    private Long gameTagId;

    private String gameTagName;

}
