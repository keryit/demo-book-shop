package spring.boot.demobooksshop.service;

import java.util.List;
import spring.boot.demobooksshop.dto.role.CreateRoleRequestDto;
import spring.boot.demobooksshop.dto.role.RoleDto;
import spring.boot.demobooksshop.model.Role;

public interface RoleService {
    RoleDto save(CreateRoleRequestDto requestDto);

    List<RoleDto> findAll();

    Role getRoleByName(Role.RoleName roleName);
}
