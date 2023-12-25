package gusta.miithersz.geekcave.models.animation;

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
public class AnimationXAnimationGenreModel {
    
    private AnimationModel animation;

    private AnimationGenreModel animationGenre;

}
