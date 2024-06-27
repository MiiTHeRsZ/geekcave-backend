package gusta.miithersz.geekcave.controllers.anime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.models.anime.AnimeStudioModel;
import gusta.miithersz.geekcave.services.anime.AnimeStudioService;


@RestController
@RequestMapping("animes/anime_studio")
public class AnimeStudioController {

    @Autowired
    private AnimeStudioService animeStudioService;

    @GetMapping("all")
    @Transactional
    public ResponseEntity<?> getAnimeStudioList() {
        List<AnimeStudioModel> animeStudios = new ArrayList<>();

        try {
            animeStudios = animeStudioService.getAnimeStudioList();

            if (animeStudios.isEmpty()) {
                return new ResponseEntity<>("Nenhum estúdio encontrado!", HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<AnimeStudioModel>>(animeStudios, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("{id}")
    @Transactional
    public ResponseEntity<?> getAnimeStudioById(@PathVariable Long id) {
        try {
            return new ResponseEntity<AnimeStudioModel>(animeStudioService.getAnimeStudioById(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

}
