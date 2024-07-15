package gusta.miithersz.geekcave.controllers.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.models.anime.AnimeTitleModel;
import gusta.miithersz.geekcave.models.anime.DTOAnimeTitleModel;
import gusta.miithersz.geekcave.services.anime.AnimeTitleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("anime/title")
@SecurityRequirement(name = "bearer-key")
public class AnimeTitleController {

    @Autowired
    private AnimeTitleService animeTitleService;

    @PutMapping("{id}")
    @Transactional
    public ResponseEntity<?> putAnimeTitle(@PathVariable("id") Long id, @RequestBody DTOAnimeTitleModel animeTitle) {
        try {
            return new ResponseEntity<AnimeTitleModel>(animeTitleService.putAnimeTitle(id, new AnimeTitleModel(animeTitle)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
