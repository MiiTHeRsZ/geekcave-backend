package gusta.miithersz.geekcave.models.anime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DTOAnimeModel(
        @NotNull Boolean animePin,
        @NotNull @Valid DTOAnimeTitleModel animeTitle,
        @NotBlank @Size(max = 5, message = "Must be up to 5 characters!") String animeTier,
        @NotBlank @Size(max = 100, message = "Must be up to 100 characters!") String animeImg,
        @NotNull @Valid DTOAnimeStudioModel animeStudio,
        @NotNull Integer animeSessions,
        @Size(max = 25, message = "Must be up to 25 characters!") String animeStatus,
        @NotBlank @Size(max = 500, message = "Must be up to 500 characters!") String animeSynopsis) {

}
