package gusta.miithersz.geekcave.services.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.anime.AnimeModel;
import gusta.miithersz.geekcave.models.anime.AnimeTitleModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeRepository;

@Service
public class AnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private AnimeTitleService animeTitleService;

    @Autowired
    private AnimeXAnimeGenreService animeXAnimeGenreService;

    public Page<AnimeModel> getAnimeList(Pageable pageable) {
        try {
            return animeRepository.findAll(pageable);
        } catch (Exception e) {
            throw e;
        }
    }

    public AnimeModel getAnimeById(Long id) {
        return animeRepository.findAnimeByAnimeId(id);
    }

    public AnimeModel postAnime(AnimeModel anime) {
        AnimeTitleModel animeTitle = animeTitleService.postAnimeTitle(anime.getAnimeTitle());

        anime.getAnimeTitle().setAnimeTitleId(animeTitle.getAnimeTitleId());

        return animeRepository.save(anime);
    }

    public AnimeModel putAnimeById(Long id, AnimeModel anime) {
        anime.setAnimeId(id);

        return animeRepository.save(anime);
    }

    public void deleteAnimeById(Long id) {
        animeXAnimeGenreService.deleteAnimeXAnimeGenreByAnimeId(id);

        animeRepository.deleteById(id);
    }

}