package spring.boot.demobooksshop.controller;

import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.demobooksshop.dto.role.CreateRoleRequestDto;
import spring.boot.demobooksshop.dto.role.RoleDto;
import spring.boot.demobooksshop.service.RoleService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private final RoleService roleService;

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping
    public List<RoleDto> findAll() {
        return roleService.findAll();
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public RoleDto save(@RequestBody @Valid CreateRoleRequestDto requestDto) {
        return roleService.save(requestDto);
    }
}
