package gusta.miithersz.geekcave.controllers.anime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.models.anime.AnimeModel;
import gusta.miithersz.geekcave.models.anime.DTOAnimeModel;
import gusta.miithersz.geekcave.services.anime.AnimeService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping("all")
    @Transactional
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

    /**
     * PathVariable == "/{var}"
     * RequestParam == value = "search", params = {"id"}
     * RequestBody
     */

    @GetMapping("{id}")
    @Transactional
    public ResponseEntity<?> getAnimeById(@PathVariable Long id) {
        try {
            return new ResponseEntity<AnimeModel>(animeService.getAnimeById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("anime")
    @Transactional
    public ResponseEntity<?> postAnime(@RequestBody @Valid DTOAnimeModel anime) {
        try {
            return new ResponseEntity<AnimeModel>(animeService.postAnime(new AnimeModel(anime)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
