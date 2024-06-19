package gusta.miithersz.geekcave.controllers.anime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.models.anime.AnimeModel;
import gusta.miithersz.geekcave.models.anime.AnimeStudioModel;
import gusta.miithersz.geekcave.models.anime.AnimeTitleModel;
import gusta.miithersz.geekcave.models.anime.DTOAnimeModel;
import gusta.miithersz.geekcave.services.anime.AnimeService;
import gusta.miithersz.geekcave.services.anime.AnimeTitleService;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("animes")
public class AnimeController {

    @Autowired
    private AnimeService animeService;

    @GetMapping("/all")
    public ResponseEntity<?> getAnimeList() {
        List<AnimeModel> animes = new ArrayList<>();

        try {
            animes = animeService.getAnimeList();

            if (animes.isEmpty()) {
                return new ResponseEntity<>("Nenhum anime encontrado!",
                        HttpStatus.NOT_FOUND);
            }

            return new ResponseEntity<List<AnimeModel>>(animes, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * PathVariable == "/{var}"
     * RequestParam == value = "search", params = {"id"}
     * RequestBody
     */

    @GetMapping
    public void getAnimeInfo(@RequestParam String param) {

    }

    @PostMapping("/anime")
    public ResponseEntity<?> postAnime(@RequestBody DTOAnimeModel anime) {
        try {
            return new ResponseEntity<AnimeModel>(animeService.postAnime(
                    new AnimeModel(
                            null,
                            anime.animePin(),
                            new AnimeTitleModel(
                                    null,
                                    anime.animeTitle().animeTitleDefault(),
                                    anime.animeTitle().animeTitleEnglish(),
                                    anime.animeTitle().animeTitleJapanese(),
                                    anime.animeTitle().animeTitleSynonyms()),
                            anime.animeTier(),
                            anime.animeImg(),
                            new AnimeStudioModel(
                                    anime.animeStudio().animeStudioId(),
                                    anime.animeStudio().animeStudioName(),
                                    anime.animeStudio().animeStudioImg()),
                            anime.animeSessions(),
                            anime.animeStatus(),
                            anime.animeSynopsis())),
                    HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
