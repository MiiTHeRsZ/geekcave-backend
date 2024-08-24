package gusta.miithersz.geekcave.dto.requests.anime;

import gusta.miithersz.geekcave.utils.enumerated.anime.title.AnimeThemeType;

public record DTOAnimeThemeModel(
        Long animeThemeId,
        DTOAnimeModel anime,
        String animeThemeName,
        String animeThemeSong,
        String animeThemeSongFull,
        AnimeThemeType animeThemeType) {

}
