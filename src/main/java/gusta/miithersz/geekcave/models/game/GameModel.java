package gusta.miithersz.geekcave.models.game;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import gusta.miithersz.geekcave.dto.requests.game.DTOGameModel;
import gusta.miithersz.geekcave.models.FranchiseModel;
import gusta.miithersz.geekcave.utils.enumerated.game.GameFeature;
import gusta.miithersz.geekcave.utils.enumerated.game.GameGenre;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
        this.gamePin = game.gamePin();
        this.franchise = new FranchiseModel(game.franchise());
        this.gameTitle = game.gameTitle();
        this.gameTier = game.gameTier();
        this.gameImg = game.gameImg();
        this.gameDeveloper = new GameDeveloperModel(game.gameDeveloper());
        this.gameReleased = game.gameReleased();
        this.gamePrequel = game.gamePrequel();
        this.gameSequel = game.gameSequel();
        this.gameCharacters = game.gameCharacters();
        this.gameGenres = game.gameGenres();
        this.gameFeatures = game.gameFeatures();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;

    @Column(name = "game_pin")
    private Boolean gamePin;

    @ManyToOne
    @JoinColumn(name = "fk_franchise_id", referencedColumnName = "franchise_id")
    private FranchiseModel franchise;

    @Column(name = "game_title")
    private String gameTitle;

    @Column(name = "game_tier")
    private String gameTier;

    @Column(name = "game_img")
    private String gameImg;

    @OneToOne
    @JoinColumn(name = "fk_game_developer_id", referencedColumnName = "game_developer_id")
    private GameDeveloperModel gameDeveloper;

    @Column(name = "game_released")
    private Date gameReleased;

    @Column(name = "game_prequel")
    private Long gamePrequel;

    @Column(name = "game_sequel")
    private Long gameSequel;

    @JsonIgnoreProperties("game")
    @OneToMany(mappedBy = "game", cascade = { CascadeType.MERGE, CascadeType.REFRESH })
    private Set<GameCharacterModel> gameCharacters;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "game_genre", joinColumns = @JoinColumn(name = "fk_game_id", referencedColumnName = "game_id"))
    @Column(name = "game_genre_name")
    private Set<GameGenre> gameGenres;

    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "game_feature", joinColumns = @JoinColumn(name = "fk_game_id", referencedColumnName = "game_id"))
    @Column(name = "game_feature_name")
    private Set<GameFeature> gameFeatures;

}
