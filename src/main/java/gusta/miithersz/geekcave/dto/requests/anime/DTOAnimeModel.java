package gusta.miithersz.geekcave.dto.requests.anime;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DTOAnimeModel(
        Long animeId,
        @NotNull(message = "Must not be null!") Boolean animePin,
        @NotNull(message = "Must not be null!") @Valid DTOAnimeTitleModel animeTitle,
        @NotBlank @Size(max = 5, message = "Must be up to 5 characters!") String animeTier,
        @NotBlank @Size(max = 100, message = "Must be up to 100 characters!") String animeImg,
        @NotNull(message = "Must not be null!") @Valid DTOAnimeStudioModel animeStudio,
        @NotNull(message = "Must not be null!") @Min(value = 1) Integer animeSessions,
        @Size(max = 25, message = "Must be up to 25 characters!") String animeStatus,
        @NotBlank @Size(max = 500, message = "Must be up to 500 characters!") String animeSynopsis) {

}
