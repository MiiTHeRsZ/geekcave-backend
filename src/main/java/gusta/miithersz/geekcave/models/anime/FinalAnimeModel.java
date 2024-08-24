package gusta.miithersz.geekcave.models.anime;

import java.util.List;

import gusta.miithersz.geekcave.utils.enumerated.anime.AnimeGenre;
import jakarta.persistence.OneToMany;

public class FinalAnimeModel {

    Long animeId;
    Boolean animePin;
    AnimeTitleModel animeTitle;
    String animeTier;
    String animeImg;
    AnimeStudioModel animeStudio;
    Integer animeSessions;
    String animeStatus;
    String animeSynopsis;
    List<AnimeGenre> animeGenres;

    @OneToMany(mappedBy = "anime")
    List<AnimeCharacterModel> animeCharacters;
    List<AnimeThemeModel> animeThemes;

}
