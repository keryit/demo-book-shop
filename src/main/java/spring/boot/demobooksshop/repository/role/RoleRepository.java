package spring.boot.demobooksshop.repository.role;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.demobooksshop.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findRoleByName(Role.RoleName roleName);
}
