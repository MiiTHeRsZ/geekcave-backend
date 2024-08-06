package gusta.miithersz.geekcave.controllers.anime;

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

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeCharacterModel;
import gusta.miithersz.geekcave.models.anime.AnimeCharacterModel;
import gusta.miithersz.geekcave.services.anime.AnimeCharacterService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/anime/character")
@SecurityRequirement(name = "bearer-key")
public class AnimeCharacterController {

    @Autowired
    private AnimeCharacterService animeCharacterService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postAnimeCharacter(@RequestBody DTOAnimeCharacterModel character) {
        try {
            return new ResponseEntity<>(animeCharacterService.postAnimeCharacter(new AnimeCharacterModel(character)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAnimeCharacterList(@PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<AnimeCharacterModel> animeCharacters = animeCharacterService.getAnimeCharacterList(pageable);

            if (animeCharacters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Page<AnimeCharacterModel>>(animeCharacters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnimeCharacterById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(animeCharacterService.getAnimeCharacterById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putAnimeCharacterById(@PathVariable Long id, DTOAnimeCharacterModel character) {
        try {
            return new ResponseEntity<>(
                    animeCharacterService.putAnimeCharacterById(id, new AnimeCharacterModel(character)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteAnimeCharacterById(@PathVariable Long id) {
        try {
            animeCharacterService.deleteAnimeCharacterById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
