package gusta.miithersz.geekcave.repositories.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.game.GameModel;

@Repository
public interface GameRepository extends JpaRepository<GameModel, Long> {

    GameModel findGameByGameId(Long id);

}
