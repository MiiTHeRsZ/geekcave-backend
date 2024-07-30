package gusta.miithersz.geekcave.controllers.anime;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.models.anime.AnimeStudioModel;
import gusta.miithersz.geekcave.models.anime.DTOAnimeStudioModel;
import gusta.miithersz.geekcave.services.anime.AnimeStudioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/animes/studio")
@SecurityRequirement(name = "bearer-key")
public class AnimeStudioController {

    @Autowired
    private AnimeStudioService animeStudioService;

    @GetMapping("/all")
    public ResponseEntity<?> getAnimeStudioList() {
        List<AnimeStudioModel> animeStudios = new ArrayList<>();

        try {
            animeStudios = animeStudioService.getAnimeStudioList();

            if (animeStudios.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<AnimeStudioModel>>(animeStudios, HttpStatus.OK);
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

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putAnimeStudio(@PathVariable Long id, @RequestBody DTOAnimeStudioModel animeStudio) {
        try {
            return new ResponseEntity<AnimeStudioModel>(
                    animeStudioService.putAnimeStudio(id, new AnimeStudioModel(animeStudio)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<?> deleteAnimeStudio(@PathVariable Long id) {
        try {
            animeStudioService.deleteAnimeStudio(id);

            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
