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

@Entity(name = "AnimeTitle")
@Table(name = "anime_title")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AnimeTitleModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "anime_title_id")
    private Integer animeTitleId;

    @Column(name = "anime_title_default")
    private String animeTitleDefault;
    
    @Column(name = "anime_title_english")
    private String animeTitleEnglish;
    
    @Column(name = "anime_title_japanese")
    private String animeTitleJapanese;

    @Column(name = "anime_title_synonyms")
    private String animeTitleSynonyms;
    
}
