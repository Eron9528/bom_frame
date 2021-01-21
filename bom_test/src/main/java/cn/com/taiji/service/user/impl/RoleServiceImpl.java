package cn.com.taiji.service.user.impl;

import cn.com.taiji.domain.user.Role;
import cn.com.taiji.domain.user.RoleRepo;
import cn.com.taiji.domain.user.User;
import cn.com.taiji.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;

    @Override
    public List<Role> findAll() {
        return roleRepo.findAll();
    }

    @Override
    public Role addRole(Role role){
        this.roleRepo.save(role);
        return role;
    }

    @Override
    public Role findById(long id) {
        return this.roleRepo.findById(id).orElse(null);
    }

    @Override
    public Role updateRoleById(long id, Role role) {
        Role oldRole = this.roleRepo.findById(id).orElse(null);
        oldRole.setRoleDesc(role.getRoleDesc());
        oldRole.setRoleName(role.getRoleName());
        this.roleRepo.save(oldRole);
        return oldRole;
    }

    @Override
    public Role deleteRoleById(long id) {
        Role role = roleRepo.findById(id).orElse(null);
        if (role != null)
            roleRepo.deleteById(id);
        return role;
    }
}
