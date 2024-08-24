package gusta.miithersz.geekcave.services.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.game.GameCharacterModel;
import gusta.miithersz.geekcave.repositories.game.GameCharacterRepository;

@Service
public class GameCharacterService {

    @Autowired
    private GameCharacterRepository gameCharacterRepository;

    public GameCharacterModel postGameCharacter(GameCharacterModel character) {
        return gameCharacterRepository.save(character);
    }

    public Page<GameCharacterModel> getGameCharacterList(Pageable pageable) {
        return gameCharacterRepository.findAll(pageable);
    }

    public GameCharacterModel getGameCharacterById(Long id) {
        return gameCharacterRepository.findGameCharacterByGameCharacterId(id);
    }

    public GameCharacterModel putGameCharacterById(Long id, GameCharacterModel character) {
        character.setGameCharacterId(id);

        return gameCharacterRepository.save(character);
    }

    public void deleteGameCharacterById(Long id) {
        gameCharacterRepository.deleteById(id);
    }

}
