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
public class SerieXSerieGenreModel {
    
    private SerieModel serie;

    private SerieGenreModel serieGenre;

}
