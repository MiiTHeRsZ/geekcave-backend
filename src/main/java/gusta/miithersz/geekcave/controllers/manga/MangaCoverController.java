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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaCoverModel;
import gusta.miithersz.geekcave.models.manga.MangaCoverModel;
import gusta.miithersz.geekcave.services.manga.MangaCoverService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/manga/cover")
@SecurityRequirement(name = "bearer-key")
public class MangaCoverController {

    @Autowired
    private MangaCoverService mangaCoverService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postMangaCover(@RequestBody DTOMangaCoverModel cover) {
        try {
            return new ResponseEntity<MangaCoverModel>(mangaCoverService.postMangaCover(new MangaCoverModel(cover)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMangaCoverByMangaId(@PathVariable Long id, Pageable pageable) {
        try {
            Page<MangaCoverModel> covers = mangaCoverService.getMangaCoverListByMangaId(id, pageable);

            if (covers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Page<MangaCoverModel>>(covers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putMangaCoverById(@PathVariable Long id, @RequestBody DTOMangaCoverModel cover) {
        try {
            return new ResponseEntity<MangaCoverModel>(mangaCoverService.putMangaCoverById(id, new MangaCoverModel(cover)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteMangaCoverById(@PathVariable Long id) {
        try {
            mangaCoverService.deleteMangaCoverById(id);

            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
