package gusta.miithersz.geekcave.models.anime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AnimeModel {

    private Integer animeId;

    private Boolean animePin;

    private AnimeTitleModel animeTitle;

    // * .webp
    private String animeImg;

    private AnimeStudioModel animeStudio;

    private Integer animeSessions;

    // * Completed / Ep
    private String animeStatus;

    private String animeSynopsis;

}
