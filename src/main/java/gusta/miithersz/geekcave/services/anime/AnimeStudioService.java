package gusta.miithersz.geekcave.services.anime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.anime.AnimeStudioModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeStudioRepository;

@Service
public class AnimeStudioService {

    @Autowired
    private AnimeStudioRepository animeStudioRepository;

    public List<AnimeStudioModel> getAnimeStudioList() {
        List<AnimeStudioModel> animeStudioList = new ArrayList<>();

        try {
            animeStudioList = animeStudioRepository.findAll();

            return animeStudioList;
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

    public AnimeStudioModel postAnimeStudio(AnimeStudioModel animeStudio) {
        return animeStudioRepository.save(animeStudio);
    }

    public AnimeStudioModel putAnimeStudio(Long id, AnimeStudioModel animeStudioModel) {
        animeStudioModel.setAnimeStudioId(id);

        return animeStudioRepository.save(animeStudioModel);
    }

    public void deleteAnimeStudio(Long id) {
        animeStudioRepository.deleteById(id);
    }

}
