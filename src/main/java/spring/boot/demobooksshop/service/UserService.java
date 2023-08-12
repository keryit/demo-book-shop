package spring.boot.demobooksshop.service;

import java.util.List;
import org.springframework.data.domain.Pageable;
import spring.boot.demobooksshop.dto.user.UserDto;
import spring.boot.demobooksshop.dto.user.UserRegisteredResponseDto;
import spring.boot.demobooksshop.dto.user.UserRegistrationRequestDto;
import spring.boot.demobooksshop.exception.RegistrationException;

public interface UserService {
    UserRegisteredResponseDto register(
            UserRegistrationRequestDto registrationRequest)
            throws RegistrationException;

    List<UserDto> findAll(Pageable pageable);
}
