package gusta.miithersz.geekcave.models.anime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DTOAnimeTitleModel(
        @NotBlank String animeTitleDefault,
        @Size(max = 100, message = "Must be up to 100 characters!") String animeTitleEnglish,
        @Size(max = 100, message = "Must be up to 100 characters!") String animeTitleJapanese,
        @Size(max = 100, message = "Must be up to 100 characters!") String animeTitleSynonyms) {

}
