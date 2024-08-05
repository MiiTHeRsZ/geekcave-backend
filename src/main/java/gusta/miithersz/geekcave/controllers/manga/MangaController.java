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

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaModel;
import gusta.miithersz.geekcave.models.manga.MangaModel;
import gusta.miithersz.geekcave.services.manga.MangaService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/manga")
@SecurityRequirement(name = "bearer-key")
public class MangaController {

    @Autowired
    private MangaService mangaService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postManga(@RequestBody DTOMangaModel manga) {
        try {
            return new ResponseEntity<MangaModel>(mangaService.postAnime(new MangaModel(manga)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getMangaList(Pageable pageable) {
        try {
            Page<MangaModel> mangas = mangaService.getMangaList(pageable);

            if (mangas.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Page<MangaModel>>(mangas, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMangaById(@PathVariable Long id) {
        try {
            return new ResponseEntity<MangaModel>(mangaService.getMangaById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putMangaById(@PathVariable Long id, @RequestBody DTOMangaModel manga) {
        try {
            return new ResponseEntity<MangaModel>(mangaService.putMangaById(id, new MangaModel(manga)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteMangaById(@PathVariable Long id) {
        try {
            mangaService.deleteMangaById(id);

            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
