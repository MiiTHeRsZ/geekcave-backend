package gusta.miithersz.geekcave.models.anime;

import java.util.List;

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
		List<AnimeGenreModel> animeGenres,
		List<AnimeCharacterModel> animeCharacters,
		List<AnimeThemeModel> animeThemes) {

}
