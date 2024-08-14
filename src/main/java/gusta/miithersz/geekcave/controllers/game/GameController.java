package gusta.miithersz.geekcave.controllers.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.dto.requests.game.DTOGameModel;
import gusta.miithersz.geekcave.models.game.GameModel;
import gusta.miithersz.geekcave.services.game.GameService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/game")
@SecurityRequirement(name = "bearer-key")
public class GameController {
    
    @Autowired
    private GameService gameService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postGame(@RequestBody DTOGameModel game) {
        try {
            return new ResponseEntity<GameModel>(gameService.postGame(new GameModel(game)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getGameList(@PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<GameModel> games = gameService.getGameList(pageable);
            
            if (games.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
            return new ResponseEntity<Page<GameModel>>(games, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getGameById(@PathVariable Long id) {
        try {
            if (gameService.getGameById(id) == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
            return new ResponseEntity<GameModel>(gameService.getGameById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putGameById(@PathVariable Long id, @RequestBody @Valid DTOGameModel game) {
        try {
            return new ResponseEntity<GameModel>(gameService.putGameById(id, new GameModel(game)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteGameById(@PathVariable Long id) {
        try {
            gameService.deleteGameById(id);
            
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
