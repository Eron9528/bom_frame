package cn.com.taiji.service.user;

import cn.com.taiji.domain.user.Role;

import java.util.List;

public interface RoleService {
    List<Role> findAll();

    Role addRole(Role role);

    Role findById(long id);

    Role updateRoleById(long id, Role role);

    Role deleteRoleById(long id);
}
