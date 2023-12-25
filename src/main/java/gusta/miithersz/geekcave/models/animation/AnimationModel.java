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
public class AnimationModel {
    
    private Integer animationId;

    private String animationTitle;

    private String animationImg;

    private String animationStatus;

}
