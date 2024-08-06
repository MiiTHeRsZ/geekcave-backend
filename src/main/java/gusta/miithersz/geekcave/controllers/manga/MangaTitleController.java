package gusta.miithersz.geekcave.controllers.manga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import gusta.miithersz.geekcave.dto.requests.manga.DTOMangaTitleModel;
import gusta.miithersz.geekcave.models.manga.MangaTitleModel;
import gusta.miithersz.geekcave.services.manga.MangaTitleService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

@RestController
@RequestMapping("/manga/title")
@SecurityRequirement(name = "bearer-key")
public class MangaTitleController {

    @Autowired
    private MangaTitleService mangaTitleService;

    @GetMapping("/search")
    public ResponseEntity<?> getMangaTitleByName(@RequestParam("name") String titleName, Pageable pageable) {
        try {
            return new ResponseEntity<Page<MangaTitleModel>>(
                    mangaTitleService.getMangaTitleByName(titleName, pageable), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<?> putMangaTitleById(@PathVariable Long id, @RequestBody DTOMangaTitleModel title) {
        try {
            return new ResponseEntity<MangaTitleModel>(
                    mangaTitleService.putMangaTitleById(id, new MangaTitleModel(title)), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
