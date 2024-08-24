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

import gusta.miithersz.geekcave.dto.requests.game.DTOGameDeveloperModel;
import gusta.miithersz.geekcave.models.game.GameDeveloperModel;
import gusta.miithersz.geekcave.services.game.GameDeveloperService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/game/developer")
@SecurityRequirement(name = "bearer-key")
public class GameDeveloperController {

    @Autowired
    private GameDeveloperService gameDeveloperService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postGameDeveloper(@RequestBody DTOGameDeveloperModel developer) {
        try {
            return new ResponseEntity<GameDeveloperModel>(
                    gameDeveloperService.postGameDeveloper(new GameDeveloperModel(developer)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getGameDeveloperList(@PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<GameDeveloperModel> gameDevelopers = gameDeveloperService.getGameDeveloperList(pageable);

            if (gameDevelopers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Page<GameDeveloperModel>>(gameDevelopers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getGameDeveloperById(@PathVariable Long id) {
        try {
            if (gameDeveloperService.getGameDeveloperById(id) == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<GameDeveloperModel>(gameDeveloperService.getGameDeveloperById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putGameDeveloperById(@PathVariable Long id,
            @RequestBody @Valid DTOGameDeveloperModel developer) {
        try {
            return new ResponseEntity<GameDeveloperModel>(
                    gameDeveloperService.putGameDeveloperById(id, new GameDeveloperModel(developer)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteGameDeveloperById(@PathVariable Long id) {
        try {
            gameDeveloperService.deleteGameDeveloperById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
