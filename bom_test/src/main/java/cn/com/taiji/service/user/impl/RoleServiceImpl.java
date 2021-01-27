package cn.com.taiji.service.user.impl;

import cn.com.taiji.domain.user.Role;
import cn.com.taiji.domain.user.RoleRepo;
import cn.com.taiji.dto.User.RoleDto;
import cn.com.taiji.service.user.PermissionService;
import cn.com.taiji.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepo roleRepo;
    @Autowired
    private PermissionService permissionService;

    @Override
    public List<RoleDto> findAll() {
        List<Role> roles = roleRepo.findAll();
        List<RoleDto> roleDtoList = new ArrayList<>();

        for(Role role : roles){
            RoleDto dto = new RoleDto();
            dto.setId(role.getId());
            dto.setRoleName(role.getRoleName());
            dto.setRoleDesc(role.getRoleDesc());
            // 再这里暂时先取得所有的权限，未来再做修改
            //todo
            dto.setChildrenList(permissionService.findTree());
            roleDtoList.add(dto);
        }

        return roleDtoList;
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
