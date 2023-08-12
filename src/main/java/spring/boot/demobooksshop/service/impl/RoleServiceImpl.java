package spring.boot.demobooksshop.service.impl;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import spring.boot.demobooksshop.dto.role.CreateRoleRequestDto;
import spring.boot.demobooksshop.dto.role.RoleDto;
import spring.boot.demobooksshop.mapper.RoleMapper;
import spring.boot.demobooksshop.model.Role;
import spring.boot.demobooksshop.repository.role.RoleRepository;
import spring.boot.demobooksshop.service.RoleService;

@RequiredArgsConstructor
@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    @Override
    public RoleDto save(CreateRoleRequestDto requestDto) {
        Role role = roleMapper.toModel(requestDto);
        return roleMapper.toDto(roleRepository.save(role));
    }

    @Override
    public List<RoleDto> findAll() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::toDto)
                .toList();
    }

    @Override
    public Role getRoleByName(Role.RoleName roleName) {
        return roleRepository.findRoleByName(roleName).orElseThrow(() ->
                new RuntimeException("can't find role by roleName: " + roleName));
    }
}
