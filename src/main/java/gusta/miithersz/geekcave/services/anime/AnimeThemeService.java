package gusta.miithersz.geekcave.services.anime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.models.anime.AnimeThemeModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeThemeRepository;

@Service
public class AnimeThemeService {
    
    @Autowired
    private AnimeThemeRepository animeThemeRepository;

    public AnimeThemeModel postAnimeTheme(AnimeThemeModel theme){
        return animeThemeRepository.save(theme);
    }

    public AnimeThemeModel putAnimeThemeById(Long id, AnimeThemeModel animeThemeModel) {
        animeThemeModel.setAnimeThemeId(id);

        return animeThemeRepository.save(animeThemeModel);
    }

    public void deleteAnimeThemeById(Long id) {
        animeThemeRepository.deleteById(id);
    }
}
