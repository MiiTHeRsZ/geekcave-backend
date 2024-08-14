package gusta.miithersz.geekcave.services.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.game.GameModel;
import gusta.miithersz.geekcave.repositories.game.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public GameModel postGame(GameModel game) {
        return gameRepository.save(game);
    }

    public Page<GameModel> getGameList(Pageable pageable) {
        return gameRepository.findAll(pageable);
    }

    public GameModel getGameById(Long id) {
        return gameRepository.findGameById(id);
    }

    public GameModel putGameById(Long id, GameModel game) {
        game.setGameId(id);

        return gameRepository.save(game);
    }

    public void deleteGameById(Long id) {
        gameRepository.deleteById(id);
    }
    
}
