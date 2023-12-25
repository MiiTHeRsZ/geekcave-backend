package gusta.miithersz.geekcave.models.animationSerie;

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
public class AnimationSerieXSerieGenreModel {
    
    private AnimationSerieModel animationSerie;

    private AnimationSerieGenreModel animationSerieGenre;

}
