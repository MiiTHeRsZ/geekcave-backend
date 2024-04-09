package gusta.miithersz.geekcave.models.anime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "AnimeStudio")
@Table(name = "anime_studio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AnimeStudioModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_studio_id")
    private Integer animeStudioId;

    @Column(name = "anime_studio_name")
    private String animeStudioName;
    
}
