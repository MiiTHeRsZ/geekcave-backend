package gusta.miithersz.geekcave.models.manga;

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
public class MangaTitleModel {
    
    private Integer mangaTitleId;

    private String mangaTitleDefault;
    
    private String mangaTitleEnglish;
    
    private String mangaTitleJapanese;

    private String mangaTitleSynonyms;
    
}
