package gusta.miithersz.geekcave.services.anime;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gusta.miithersz.geekcave.dto.responses.anime.FinalDTOAnime;
import gusta.miithersz.geekcave.models.anime.AnimeCharacterModel;
import gusta.miithersz.geekcave.models.anime.AnimeModel;
import gusta.miithersz.geekcave.models.anime.AnimeThemeModel;
import gusta.miithersz.geekcave.repositories.anime.AnimeCharacterRepository;
import gusta.miithersz.geekcave.repositories.anime.AnimeRepository;
import gusta.miithersz.geekcave.repositories.anime.AnimeThemeRepository;
import gusta.miithersz.geekcave.utils.enumerated.anime.AnimeGenre;

@Service
public class FinalAnimeService {

    @Autowired
    private AnimeRepository animeRepository;

    @Autowired
    private AnimeCharacterRepository animeCharacterRepository;

    @Autowired
    private AnimeThemeRepository animeThemeRepository;

    public FinalDTOAnime getFullAnimeById(Long id) {
        FinalDTOAnime anime;

        try {
            AnimeModel animeModel = animeRepository.findAnimeByAnimeId(id);

            if (animeModel == null) {
                return null;
            }

            List<AnimeGenre> animeGenreModels = new ArrayList<>();

            List<AnimeCharacterModel> animeCharacterModels = animeCharacterRepository.findAllByAnime_AnimeId(id);

            List<AnimeThemeModel> animeThemeModels = animeThemeRepository.findAllByAnime_AnimeId(id);

            anime = new FinalDTOAnime(id,
                    animeModel.getAnimePin(),
                    animeModel.getAnimeTitle(),
                    animeModel.getAnimeTier(),
                    animeModel.getAnimeImg(),
                    animeModel.getAnimeStudio(),
                    animeModel.getAnimeSessions(),
                    animeModel.getAnimeStatus(),
                    animeModel.getAnimeSynopsis(),
                    animeGenreModels,
                    animeCharacterModels,
                    animeThemeModels);
        } catch (Exception e) {
            throw e;
        }

        return anime;
    }

}
