package gusta.miithersz.geekcave.models.anime;

import java.util.ArrayList;

public record FinalDTOAnime(
        Long animeId,
        Boolean animePin,
        AnimeTitleModel animeTitle,
        String animeTier,
        String animeImg,
        AnimeStudioModel animeStudio,
        Integer animeSessions,
        String animeStatus,
        String animeSynopsis,
        ArrayList<AnimeGenreModel> animeGenres,
        ArrayList<AnimeCharacterModel> animeCharacters,
        ArrayList<AnimeThemeModel> animeThemes) {

}
