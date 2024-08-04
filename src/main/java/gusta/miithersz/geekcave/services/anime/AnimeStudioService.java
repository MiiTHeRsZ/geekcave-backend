package gusta.miithersz.geekcave.services.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.anime.AnimeStudioModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeStudioRepository;

@Service
public class AnimeStudioService {

    @Autowired
    private AnimeStudioRepository animeStudioRepository;

    public AnimeStudioModel postAnimeStudio(AnimeStudioModel animeStudio) {
        return animeStudioRepository.save(animeStudio);
    }
    
    public Page<AnimeStudioModel> getAnimeStudioList(Pageable pageable) {
        try {
            return animeStudioRepository.findAll(pageable);
        } catch (Exception e) {
            throw e;
        }
    }

    public AnimeStudioModel getAnimeStudioById(Long id) {
        try {
            return animeStudioRepository.findAnimeStudioByAnimeStudioId(id);
        } catch (Exception e) {
            throw e;
        }
    }

    public AnimeStudioModel putAnimeStudioById(Long id, AnimeStudioModel animeStudioModel) {
        animeStudioModel.setAnimeStudioId(id);

        return animeStudioRepository.save(animeStudioModel);
    }

    public void deleteAnimeStudioById(Long id) {
        animeStudioRepository.deleteById(id);
    }

}
