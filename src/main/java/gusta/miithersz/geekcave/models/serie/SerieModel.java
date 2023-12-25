package gusta.miithersz.geekcave.models.serie;

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
public class SerieModel {
    
    private Integer serieId;

    private String serieTitle;

    private String serieImg;

    private Integer serieSessions;

    private String serieStatus;

}
