package gusta.miithersz.geekcave.models.film;

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
public class FilmModel {
    
    private Integer filmId;

    private String filmTitle;

    private String filmImg;

    private String filmStatus;

}
