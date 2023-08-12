package spring.boot.demobooksshop.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import spring.boot.demobooksshop.config.MapperConfig;
import spring.boot.demobooksshop.dto.role.CreateRoleRequestDto;
import spring.boot.demobooksshop.dto.role.RoleDto;
import spring.boot.demobooksshop.model.Role;

@Mapper(config = MapperConfig.class)
public interface RoleMapper {
    RoleDto toDto(Role role);

    @Mapping(target = "id", ignore = true)
    Role toModel(CreateRoleRequestDto requestDto);
}
