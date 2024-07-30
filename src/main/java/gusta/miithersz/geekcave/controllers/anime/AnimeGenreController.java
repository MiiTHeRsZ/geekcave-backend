package gusta.miithersz.geekcave.controllers.anime;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.models.anime.AnimeGenreModel;
import gusta.miithersz.geekcave.models.anime.DTOAnimeGenreModel;
import gusta.miithersz.geekcave.services.anime.AnimeGenreService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/animes/genre")
@SecurityRequirement(name = "bearer-key")
public class AnimeGenreController {

    @Autowired
    private AnimeGenreService animeGenreService;

    @GetMapping
    public ResponseEntity<?> getAnimeGenre() {
        try {
            List<AnimeGenreModel> animeGenres = animeGenreService.getAnimeGenreList();

            if (animeGenres.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<AnimeGenreModel>>(animeGenres, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    @Transactional
    public ResponseEntity<?> postAnimeGenre(DTOAnimeGenreModel animeGenre) {
        try {
            return new ResponseEntity<>(animeGenreService.postAnimeGenre(new AnimeGenreModel(animeGenre)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putAnimeGenre(@PathVariable("id") Long id, DTOAnimeGenreModel animeGenre) {
        try {
            return new ResponseEntity<>(animeGenreService.putAnimeGenre(id, new AnimeGenreModel(animeGenre)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteAnimeGenre(@PathVariable("id") Long id) {
        try {
            animeGenreService.deleteAnimeGenre(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
