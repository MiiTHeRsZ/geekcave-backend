package gusta.miithersz.geekcave.services.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.anime.AnimeTitleModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeTitleRepository;

@Service
public class AnimeTitleService {

    @Autowired
    private AnimeTitleRepository animeTitleRepository;

    public AnimeTitleModel postAnimeTitle(AnimeTitleModel animeTitle) {
        return animeTitleRepository.save(animeTitle);
    }

    public AnimeTitleModel putAnimeTitle(Long id, AnimeTitleModel animeTitle) {
        animeTitle.setAnimeTitleId(id);

        return animeTitleRepository.save(animeTitle);
    }

}
