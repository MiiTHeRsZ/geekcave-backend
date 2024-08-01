package gusta.miithersz.geekcave.controllers.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.models.anime.AnimeThemeModel;
import gusta.miithersz.geekcave.models.anime.DTOAnimeThemeModel;
import gusta.miithersz.geekcave.services.anime.AnimeThemeService;

@RestController
@RequestMapping("/animes/theme")
public class AnimeThemeController {

    @Autowired
    private AnimeThemeService animeThemeService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postAnimeTheme(@RequestBody DTOAnimeThemeModel theme){
        try {
            return new ResponseEntity<AnimeThemeModel>(animeThemeService.postAnimeTheme(new AnimeThemeModel(theme)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
