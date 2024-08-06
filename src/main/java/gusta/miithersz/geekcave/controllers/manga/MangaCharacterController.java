package gusta.miithersz.geekcave.controllers.manga;

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

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaCharacterModel;
import gusta.miithersz.geekcave.models.manga.MangaCharacterModel;
import gusta.miithersz.geekcave.services.manga.MangaCharacterService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/manga/character")
@SecurityRequirement(name = "bearer-key")
public class MangaCharacterController {

    @Autowired
    private MangaCharacterService mangaCharacterService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postMangaCharacter(@RequestBody DTOMangaCharacterModel character) {
        try {
            return new ResponseEntity<>(mangaCharacterService.postMangaCharacter(new MangaCharacterModel(character)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getMangaCharacterList(@PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<MangaCharacterModel> characters = mangaCharacterService.getMangaCharacterList(pageable);

            if (characters.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Page<MangaCharacterModel>>(characters, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMangaCharacterById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(mangaCharacterService.getMangaCharacterById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putMangaCharacterById(@PathVariable Long id, DTOMangaCharacterModel character) {
        try {
            return new ResponseEntity<>(
                    mangaCharacterService.putMangaCharacterById(id, new MangaCharacterModel(character)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteMangaCharacterById(@PathVariable Long id) {
        try {
            mangaCharacterService.deleteMangaCharacterById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
