package gusta.miithersz.geekcave.repositories.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.game.GameDeveloperModel;

@Repository
public interface GameDeveloperRepository extends JpaRepository<GameDeveloperModel, Long> {

    GameDeveloperModel findGameDeveloperByGameDeveloperId(Long id);

}
