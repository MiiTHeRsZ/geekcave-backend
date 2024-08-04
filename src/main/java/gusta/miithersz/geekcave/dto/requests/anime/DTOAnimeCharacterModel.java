package gusta.miithersz.geekcave.dto.requests.anime;

import gusta.miithersz.geekcave.models.anime.AnimeModel;

public record DTOAnimeCharacterModel(
		AnimeModel anime,
		String animeCharacterName,
		String animeCharacterImg) {

}
