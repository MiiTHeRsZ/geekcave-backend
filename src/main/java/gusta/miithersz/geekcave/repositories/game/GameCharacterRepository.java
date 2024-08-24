package gusta.miithersz.geekcave.repositories.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gusta.miithersz.geekcave.models.game.GameCharacterModel;

@Repository
public interface GameCharacterRepository extends JpaRepository<GameCharacterModel, Long> {

    GameCharacterModel findGameCharacterByGameCharacterId(Long id);

}
