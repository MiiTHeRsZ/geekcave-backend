package gusta.miithersz.geekcave.models.anime;

import java.util.List;

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
    List<AnimeGenreModel> animeGenres;

    @OneToMany(mappedBy = "anime")
    List<AnimeCharacterModel> animeCharacters;
    List<AnimeThemeModel> animeThemes;

}
