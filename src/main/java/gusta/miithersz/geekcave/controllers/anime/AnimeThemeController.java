package gusta.miithersz.geekcave.controllers.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeThemeModel;
import gusta.miithersz.geekcave.models.anime.AnimeThemeModel;
import gusta.miithersz.geekcave.services.anime.AnimeThemeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/anime/theme")
@SecurityRequirement(name = "bearer-key")
public class AnimeThemeController {

    @Autowired
    private AnimeThemeService animeThemeService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postAnimeTheme(@RequestBody DTOAnimeThemeModel theme) {
        try {
            return new ResponseEntity<AnimeThemeModel>(animeThemeService.postAnimeTheme(new AnimeThemeModel(theme)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putAnimeThemeById(@PathVariable Long id, @RequestBody DTOAnimeThemeModel theme) {
        try {
            return new ResponseEntity<AnimeThemeModel>(animeThemeService.putAnimeThemeById(id, new AnimeThemeModel(theme)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteAnimeThemeById(@PathVariable Long id) {
        try {
            animeThemeService.deleteAnimeThemeById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
