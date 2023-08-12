package spring.boot.demobooksshop.dto.role;

import lombok.Data;
import spring.boot.demobooksshop.model.Role;

@Data
public class CreateRoleRequestDto {
    private Role.RoleName name;
}
