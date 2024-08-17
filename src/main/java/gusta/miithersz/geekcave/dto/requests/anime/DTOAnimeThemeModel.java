package gusta.miithersz.geekcave.dto.requests.anime;

public record DTOAnimeThemeModel(
        Long animeThemeId,
        DTOAnimeModel anime,
        String animeThemeName,
        String animeThemeSong,
        String animeThemeSongFull,
        String animeThemeType) {

}
