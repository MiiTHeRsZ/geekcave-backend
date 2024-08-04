package gusta.miithersz.geekcave.controllers.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeXAnimeGenreModel;
import gusta.miithersz.geekcave.models.anime.AnimeXAnimeGenreModel;
import gusta.miithersz.geekcave.services.anime.AnimeXAnimeGenreService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/animes/animexanimegenre")
@SecurityRequirement(name = "bearer-key")
public class AnimeXAnimeGenreController {

    @Autowired
    private AnimeXAnimeGenreService animeXAnimeGenreService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postAnimeXAnimeGenre(@RequestBody DTOAnimeXAnimeGenreModel animeXAnimeGenre) {
        try {
            return new ResponseEntity<AnimeXAnimeGenreModel>(
                    animeXAnimeGenreService.postAnimeXAnimeGenre(new AnimeXAnimeGenreModel(animeXAnimeGenre)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // * To do
    /* @GetMapping("/search")
    public ResponseEntity<?> getAnimeXAnimeGenreSearchByAnime(@RequestParam String anime, @PageableDefault(size = 10) Pageable pageable) {
        try {
            return new ResponseEntity<Page<AnimeXAnimeGenreModel>>(
                    animeXAnimeGenreService.getAnimeXAnimeGenreSearchByAnime(anime, pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> getAnimeXAnimeGenreSearchByGenre(@RequestParam String anime, @PageableDefault(size = 10) Pageable pageable) {
        try {
            return new ResponseEntity<Page<AnimeXAnimeGenreModel>>(
                    animeXAnimeGenreService.getAnimeXAnimeGenreSearchByAnime(anime, pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } */

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteAnimeXAnimeGenreById(@PathVariable Long id) {
        try {
            animeXAnimeGenreService.deleteAnimeXAnimeGenreById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
