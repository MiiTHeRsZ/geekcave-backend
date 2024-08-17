package gusta.miithersz.geekcave.dto.requests.anime;

public record DTOAnimeCharacterModel(
		Long animeCharacterId,
		DTOAnimeModel anime,
		String animeCharacterName,
		String animeCharacterImg) {

}
