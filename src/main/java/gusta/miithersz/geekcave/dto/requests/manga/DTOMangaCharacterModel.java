package gusta.miithersz.geekcave.dto.requests.manga;

public record DTOMangaCharacterModel(
        Long mangaCharacterId,
        DTOMangaModel manga,
        String mangaCharacterName,
        String mangaCharacterImg) {

}
