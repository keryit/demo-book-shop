package spring.boot.demobooksshop.dto.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record UserLoginRequestDto(@NotEmpty
                                  @Size(min = 4, max = 50)
                                  @Email
                                  String email,
                                  @NotEmpty
                                  @Size(min = 6, max = 50)
                                  String password) {
}
