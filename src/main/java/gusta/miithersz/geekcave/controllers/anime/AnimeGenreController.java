package gusta.miithersz.geekcave.controllers.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeGenreModel;
import gusta.miithersz.geekcave.models.anime.AnimeGenreModel;
import gusta.miithersz.geekcave.services.anime.AnimeGenreService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/animes/genre")
@SecurityRequirement(name = "bearer-key")
public class AnimeGenreController {

    @Autowired
    private AnimeGenreService animeGenreService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postAnimeGenre(@RequestBody DTOAnimeGenreModel genre) {
        try {
            return new ResponseEntity<AnimeGenreModel>(animeGenreService.postAnimeGenre(new AnimeGenreModel(genre)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getAnimeGenreList(Pageable pageable) {
        try {
            Page<AnimeGenreModel> animeGenres = animeGenreService.getAnimeGenreList(pageable);

            if (animeGenres.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Page<AnimeGenreModel>>(animeGenres, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ! Maybe patch ?
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putAnimeGenreById(@PathVariable Long id, DTOAnimeGenreModel genre) {
        try {
            return new ResponseEntity<AnimeGenreModel>(animeGenreService.putAnimeGenreById(id, new AnimeGenreModel(genre)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteAnimeGenreById(@PathVariable Long id) {
        try {
            animeGenreService.deleteAnimeGenreById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
