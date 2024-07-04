package gusta.miithersz.geekcave.models.anime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DTOAnimeStudioModel(
                @NotNull @Pattern(regexp = "[0-9]+") Long animeStudioId,
                @NotBlank @Size(max = 50, message = "Must be up to 50 characters!") String animeStudioName,
                @NotBlank @Size(max = 100, message = "Must be up to 100 characters!") String animeStudioImg) {

}
