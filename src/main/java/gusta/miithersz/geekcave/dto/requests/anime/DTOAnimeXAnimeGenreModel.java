package gusta.miithersz.geekcave.dto.requests.anime;

public record DTOAnimeXAnimeGenreModel(
        Long animeXAnimeGenreId,
        DTOAnimeModel anime,
        DTOAnimeGenreModel animeGenre) {

}
