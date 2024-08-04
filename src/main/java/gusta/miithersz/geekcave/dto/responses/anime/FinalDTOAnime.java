package gusta.miithersz.geekcave.dto.responses.anime;

import java.util.List;

import gusta.miithersz.geekcave.models.anime.AnimeCharacterModel;
import gusta.miithersz.geekcave.models.anime.AnimeGenreModel;
import gusta.miithersz.geekcave.models.anime.AnimeStudioModel;
import gusta.miithersz.geekcave.models.anime.AnimeThemeModel;
import gusta.miithersz.geekcave.models.anime.AnimeTitleModel;

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
