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

import gusta.miithersz.geekcave.dto.requests.game.DTOGameCharacterModel;
import gusta.miithersz.geekcave.models.game.GameCharacterModel;
import gusta.miithersz.geekcave.services.game.GameCharacterService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/game/character")
@SecurityRequirement(name = "bearer-key")
public class GameCharacterController {

    @Autowired
    private GameCharacterService gameCharacterService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postGameCharacter(@RequestBody DTOGameCharacterModel character) {
        try {
            return new ResponseEntity<GameCharacterModel>(
                    gameCharacterService.postGameCharacter(new GameCharacterModel(character)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getGameCharacterList(@PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<GameCharacterModel> gameCharacters = gameCharacterService.getGameCharacterList(pageable);

            if (gameCharacters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Page<GameCharacterModel>>(gameCharacters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGameCharacterById(@PathVariable Long id) {
        try {
            if (gameCharacterService.getGameCharacterById(id) == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<GameCharacterModel>(gameCharacterService.getGameCharacterById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putGameCharacterById(@PathVariable Long id,
            @RequestBody @Valid DTOGameCharacterModel character) {
        try {
            return new ResponseEntity<GameCharacterModel>(
                    gameCharacterService.putGameCharacterById(id, new GameCharacterModel(character)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteGameCharacterById(@PathVariable Long id) {
        try {
            gameCharacterService.deleteGameCharacterById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
