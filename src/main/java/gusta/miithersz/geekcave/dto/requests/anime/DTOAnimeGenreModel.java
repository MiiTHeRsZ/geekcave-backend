package gusta.miithersz.geekcave.dto.requests.anime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DTOAnimeGenreModel(
        @NotBlank @Size(max = 25, message = "Must be up to 25 characters!") String animeGenreName) {

}
