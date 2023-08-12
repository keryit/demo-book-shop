package spring.boot.demobooksshop.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import spring.boot.demobooksshop.dto.user.UserDto;
import spring.boot.demobooksshop.dto.user.UserRegisteredResponseDto;
import spring.boot.demobooksshop.dto.user.UserRegistrationRequestDto;
import spring.boot.demobooksshop.exception.RegistrationException;
import spring.boot.demobooksshop.mapper.UserMapper;
import spring.boot.demobooksshop.model.Role;
import spring.boot.demobooksshop.model.User;
import spring.boot.demobooksshop.repository.user.UserRepository;
import spring.boot.demobooksshop.service.RoleService;
import spring.boot.demobooksshop.service.UserService;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final RoleService roleService;
    private final UserMapper userMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserRegisteredResponseDto register(
            UserRegistrationRequestDto registrationRequest)
            throws RegistrationException {
        if (userRepository.findByEmail(registrationRequest.getEmail()).isPresent()) {
            throw new RegistrationException("This email already exist");
        }
        User user = userMapper.toModel(registrationRequest);
        user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
        user.setRoles(new HashSet<>(Set.of(roleService.getRoleByName(Role.RoleName.ROLE_USER))));
        return userMapper.toRegisteredDto(userRepository.save(user));
    }

    @Override
    public List<UserDto> findAll(Pageable pageable) {
        return userRepository.findAll(pageable)
                .stream()
                .map(userMapper::toDto)
                .toList();
    }
}
