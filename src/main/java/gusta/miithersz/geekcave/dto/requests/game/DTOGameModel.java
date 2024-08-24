package gusta.miithersz.geekcave.dto.requests.game;

import java.util.Date;
import java.util.Set;

import gusta.miithersz.geekcave.models.game.GameCharacterModel;
import gusta.miithersz.geekcave.utils.enumerated.game.GameFeature;
import gusta.miithersz.geekcave.utils.enumerated.game.GameGenre;

public record DTOGameModel(
		Long gameId,
		Boolean gamePin,
		String gameTitle,
		String gameTier,
		String gameImg,
		DTOGameDeveloperModel gameDeveloper,
		Date gameReleased,
		Long gamePrequel,
		Long gameSequel,
		Set<GameCharacterModel> gameCharacters,
		Set<GameGenre> gameGenres,
		Set<GameFeature> gameFeatures) {

}
