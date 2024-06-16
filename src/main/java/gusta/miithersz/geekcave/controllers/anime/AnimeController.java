package gusta.miithersz.geekcave.controllers.anime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.models.anime.AnimeModel;
import gusta.miithersz.geekcave.services.anime.AnimeService;

@RestController
@RequestMapping("animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping
    public ResponseEntity<?> getAnimeList() {
        List<AnimeModel> animes = new ArrayList<>();

        try {
            animes = animeService.getAnimeList();

            if (animes.isEmpty()) {
                return new ResponseEntity<>("Nenhum anime encontrado!", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<AnimeModel>>(animes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
