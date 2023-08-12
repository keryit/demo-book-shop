package spring.boot.demobooksshop.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.demobooksshop.dto.user.UserLoginRequestDto;
import spring.boot.demobooksshop.dto.user.UserLoginResponseDto;
import spring.boot.demobooksshop.dto.user.UserRegisteredResponseDto;
import spring.boot.demobooksshop.dto.user.UserRegistrationRequestDto;
import spring.boot.demobooksshop.exception.RegistrationException;
import spring.boot.demobooksshop.security.AuthenticationService;
import spring.boot.demobooksshop.service.UserService;

@RequiredArgsConstructor
@Tag(name = "Authentication", description = "API for login and register user")
@RestController
@RequestMapping("/api/auth")
public class AuthenticationController {
    private final UserService userService;
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    @Operation(summary = "Login user")
    public UserLoginResponseDto login(@RequestBody UserLoginRequestDto requestDto) {
        return authenticationService.authenticate(requestDto);

    }

    @PostMapping("/register")
    @Operation(summary = "Register user")
    public UserRegisteredResponseDto register(@RequestBody @Valid
                                                  UserRegistrationRequestDto request)
            throws RegistrationException {
        return userService.register(request);
    }
}
