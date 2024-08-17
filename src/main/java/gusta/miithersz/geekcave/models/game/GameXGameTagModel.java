package gusta.miithersz.geekcave.models.game;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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
public class GameXGameTagModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_x_game_tag_id")
    private Long gameXGameTagId;

    @OneToOne
    @JoinColumn(name = "fk_game_id", referencedColumnName = "game_id")
    private GameModel game;

    @OneToOne
    @JoinColumn(name = "fk_game_tag_id", referencedColumnName = "game_tag_id")
    private GameTagModel gameTag;

}
