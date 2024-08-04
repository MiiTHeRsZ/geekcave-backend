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

import gusta.miithersz.geekcave.dto.requests.anime.DTOAnimeStudioModel;
import gusta.miithersz.geekcave.models.anime.AnimeStudioModel;
import gusta.miithersz.geekcave.services.anime.AnimeStudioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/animes/studio")
@SecurityRequirement(name = "bearer-key")
public class AnimeStudioController {

    @Autowired
    private AnimeStudioService animeStudioService;

    @PostMapping
    @Transactional
    public ResponseEntity<?> postAnimeStudio(@RequestBody DTOAnimeStudioModel animeStudio) {
        try {
            return new ResponseEntity<AnimeStudioModel>(
                    animeStudioService.postAnimeStudio(new AnimeStudioModel(animeStudio)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAnimeStudioList(Pageable pageable) {
        try {
            Page<AnimeStudioModel> animeStudios = animeStudioService.getAnimeStudioList(pageable);

            if (animeStudios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<Page<AnimeStudioModel>>(animeStudios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getAnimeStudioById(@PathVariable Long id) {
        try {
            return new ResponseEntity<AnimeStudioModel>(animeStudioService.getAnimeStudioById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putAnimeStudioById(@PathVariable Long id, @RequestBody DTOAnimeStudioModel animeStudio) {
        try {
            return new ResponseEntity<AnimeStudioModel>(
                    animeStudioService.putAnimeStudioById(id, new AnimeStudioModel(animeStudio)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteAnimeStudioById(@PathVariable Long id) {
        try {
            animeStudioService.deleteAnimeStudioById(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
