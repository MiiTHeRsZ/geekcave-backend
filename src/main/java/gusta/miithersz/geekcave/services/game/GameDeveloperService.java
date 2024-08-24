package gusta.miithersz.geekcave.services.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.game.GameDeveloperModel;
import gusta.miithersz.geekcave.repositories.game.GameDeveloperRepository;

@Service
public class GameDeveloperService {

    @Autowired
    private GameDeveloperRepository gameDeveloperRepository;

    public GameDeveloperModel postGameDeveloper(GameDeveloperModel developer) {
        return gameDeveloperRepository.save(developer);
    }

    public Page<GameDeveloperModel> getGameDeveloperList(Pageable pageable) {
        return gameDeveloperRepository.findAll(pageable);
    }

    public GameDeveloperModel getGameDeveloperById(Long id) {
        return gameDeveloperRepository.findGameDeveloperByGameDeveloperId(id);
    }

    public GameDeveloperModel putGameDeveloperById(Long id, GameDeveloperModel developer) {
        developer.setGameDeveloperId(id);

        return gameDeveloperRepository.save(developer);
    }

    public void deleteGameDeveloperById(Long id) {
        gameDeveloperRepository.deleteById(id);
    }

}
