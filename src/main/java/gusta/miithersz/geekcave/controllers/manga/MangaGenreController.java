package gusta.miithersz.geekcave.controllers.manga;

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

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaGenreModel;
import gusta.miithersz.geekcave.models.manga.MangaGenreModel;
import gusta.miithersz.geekcave.services.manga.MangaGenreService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/manga/genre")
@SecurityRequirement(name = "bearer-key")
public class MangaGenreController {

    @Autowired
    private MangaGenreService mangaGenreService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postMangaGenre(@RequestBody DTOMangaGenreModel genre) {
        try {
            return new ResponseEntity<MangaGenreModel>(mangaGenreService.postMangaGenre(new MangaGenreModel(genre)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<?> getMangaGenreList(Pageable pageable) {
        try {
            Page<MangaGenreModel> genres = mangaGenreService.getMangaGenreList(pageable);

            if (genres.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Page<MangaGenreModel>>(genres, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // ! Maybe patch ?
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putMangaGenreById(@PathVariable Long id, DTOMangaGenreModel genre) {
        try {
            return new ResponseEntity<MangaGenreModel>(mangaGenreService.putMangaGenreById(id, new MangaGenreModel(genre)),
                    HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteMangaGenreById(@PathVariable Long id) {
        try {
            mangaGenreService.deleteMangaGenreById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
