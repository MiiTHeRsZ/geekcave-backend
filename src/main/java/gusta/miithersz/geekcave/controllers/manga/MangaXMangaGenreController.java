package gusta.miithersz.geekcave.controllers.manga;

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

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaXMangaGenreModel;
import gusta.miithersz.geekcave.models.manga.MangaXMangaGenreModel;
import gusta.miithersz.geekcave.services.manga.MangaXMangaGenreService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/manga/mangaxmangagenre")
@SecurityRequirement(name = "bearer-key")
public class MangaXMangaGenreController {

    @Autowired
    private MangaXMangaGenreService mangaXMangaGenreService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postMangaXMangaGenre(@RequestBody DTOMangaXMangaGenreModel mangaXMangaGenre) {
        try {
            return new ResponseEntity<MangaXMangaGenreModel>(
                    mangaXMangaGenreService.postMangaXMangaGenre(new MangaXMangaGenreModel(mangaXMangaGenre)),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // * To do
    /* @GetMapping("/search")
    public ResponseEntity<?> getMangaXMangaGenreSearchByManga(@RequestParam String manga, @PageableDefault(size = 10) Pageable pageable) {
        try {
            return new ResponseEntity<Page<MangaXMangaGenreModel>>(
                    mangaXMangaGenreService.getMangaXMangaGenreSearchByManga(manga, pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<?> getMangaXMangaGenreSearchByGenre(@RequestParam String manga, @PageableDefault(size = 10) Pageable pageable) {
        try {
            return new ResponseEntity<Page<MangaXMangaGenreModel>>(
                    mangaXMangaGenreService.getMangaXMangaGenreSearchByManga(manga, pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } */

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteMangaXMangaGenreById(@PathVariable Long id) {
        try {
            mangaXMangaGenreService.deleteMangaXMangaGenreById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
