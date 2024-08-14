package gusta.miithersz.geekcave.dto.requests.game;

public record DTOGameCharacterModel(
        Long gameCharacterId,
        DTOGameModel game,
        String gameCharacterName,
        String gameCharacterImg) {

}
