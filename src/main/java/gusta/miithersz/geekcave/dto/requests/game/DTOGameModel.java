package gusta.miithersz.geekcave.dto.requests.game;

import java.util.Date;

public record DTOGameModel(
        Long gameId,
        String gameTitle,
        String gameImg,
        DTOGameDeveloperModel gameDeveloper,
        Date gameReleased) {

}
