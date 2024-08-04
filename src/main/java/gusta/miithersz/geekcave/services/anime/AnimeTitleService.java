package gusta.miithersz.geekcave.services.anime;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    public Page<AnimeTitleModel> getAnimeTitleByName(String name, @PageableDefault(size = 10) Pageable pageable) {
        return animeTitleRepository.findAllByAnimeTitleName(name, pageable);
    }

    public AnimeTitleModel putAnimeTitleById(Long id, AnimeTitleModel animeTitle) {
        animeTitle.setAnimeTitleId(id);

        return animeTitleRepository.save(animeTitle);
    }
    
}
