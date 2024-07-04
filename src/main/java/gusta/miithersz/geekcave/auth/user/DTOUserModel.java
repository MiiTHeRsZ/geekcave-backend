package gusta.miithersz.geekcave.auth.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DTOUserModel(
                @NotBlank String userUsername,
                @NotBlank String userPassword,
                @NotBlank @Pattern(regexp = "[A-Z]*") String userRole) {
}
