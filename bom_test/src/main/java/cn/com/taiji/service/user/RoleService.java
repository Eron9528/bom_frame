package cn.com.taiji.service.user;

import cn.com.taiji.domain.user.Role;
import cn.com.taiji.dto.User.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();

    Role addRole(Role role);

    Role findById(long id);

    Role updateRoleById(long id, Role role);

    Role deleteRoleById(long id);
}
