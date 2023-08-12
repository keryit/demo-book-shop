package spring.boot.demobooksshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring.boot.demobooksshop.config.MapperConfig;
import spring.boot.demobooksshop.dto.user.UserDto;
import spring.boot.demobooksshop.dto.user.UserRegisteredResponseDto;
import spring.boot.demobooksshop.dto.user.UserRegistrationRequestDto;
import spring.boot.demobooksshop.model.User;

@Mapper(config = MapperConfig.class)
public interface UserMapper {
    UserDto toDto(User user);

    UserRegisteredResponseDto toRegisteredDto(User user);

    @Mapping(target = "id", ignore = true)
    User toModel(UserRegistrationRequestDto requestDto);
}
