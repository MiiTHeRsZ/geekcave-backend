package gusta.miithersz.geekcave.controllers.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.models.anime.AnimeModel;
import gusta.miithersz.geekcave.models.anime.DTOAnimeModel;
import gusta.miithersz.geekcave.models.anime.FinalDTOAnime;
import gusta.miithersz.geekcave.services.anime.AnimeService;
import gusta.miithersz.geekcave.services.anime.FinalAnimeService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/animes")
/* @EnableMethodSecurity(securedEnabled = true) */
@SecurityRequirement(name = "bearer-key")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @Autowired 
    private FinalAnimeService finalAnimeService;
    
    /* Return 204 no content, set this default */
    @PostMapping("/anime")
    @Transactional
    public ResponseEntity<?> postAnime(@RequestBody @Valid DTOAnimeModel anime) {
        try {
            return new ResponseEntity<AnimeModel>(animeService.postAnime(new AnimeModel(anime)), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAnimeList(@PageableDefault(size = 10) Pageable pageable) {
        try {
            Page<AnimeModel> animes = animeService.getAnimeList(pageable);
            
            if (animes.isEmpty()) {
                return new ResponseEntity<>("Nenhum anime encontrado!", HttpStatus.NOT_FOUND);
            }
            
            return new ResponseEntity<Page<AnimeModel>>(animes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getAnimeById(@PathVariable Long id) {
        try {
            if (animeService.getAnimeById(id) == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
            return new ResponseEntity<AnimeModel>(animeService.getAnimeById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/full/{id}")
    public ResponseEntity<?> getFullAnimeById(@PathVariable Long id) {
        try {
            if (finalAnimeService.getFullAnimeById(id) == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            
            return new ResponseEntity<FinalDTOAnime>(finalAnimeService.getFullAnimeById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putAnime(@PathVariable Long id, @RequestBody @Valid DTOAnimeModel anime) {
        try {
            return new ResponseEntity<AnimeModel>(animeService.putAnime(id, new AnimeModel(anime)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/{id}")
    @Transactional
    /* @Secured("ROLE_ADMIN") */
    public ResponseEntity<?> deleteAnime(@PathVariable Long id) {
        try {
            animeService.deleteAnime(id);
            
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
