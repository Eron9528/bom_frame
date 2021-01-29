package cn.com.taiji.service.user.impl;

import cn.com.taiji.domain.rightsTree.Children;
import cn.com.taiji.domain.user.Permission;
import cn.com.taiji.domain.user.Role;
import cn.com.taiji.domain.user.RoleRepo;
import cn.com.taiji.dto.User.RoleDto;
import cn.com.taiji.service.user.PermissionService;
import cn.com.taiji.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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

    @Override
    public Permission deleteRoleRightById(long rightId, long roleId) {
        // 获取此id 的所有子孩子权限
        List<Permission> rights = permissionService.findChildRightByUpId(rightId);
        // 获取此id 的权限并添加到rights 里面取
        Permission right = permissionService.findById(rightId);
        rights.add(right);

        Role role = roleRepo.findById(roleId).orElse(null);
        Set<Permission> permissionSet = role.getPermissions();
        permissionSet.forEach(permission -> {
           if (rights.contains(permission)){
               permissionSet.remove(permission);
           }
        });

        role.setPermissions(permissionSet);
        roleRepo.save(role);
        return right;
    }

    @Override
    public List<Children> findRoleRightsById(long roleId) {
        Role role = roleRepo.findById(roleId).orElse(null);
        // 这样是否可以直接获取所有权限
        Set<Permission> permissionsSet = role.getPermissions();
        List<Children> childrenList = new ArrayList<>();
        permissionsSet.forEach(permission -> {

        });
        return childrenList;
    }

    @Override
    public Role updateRights(long roleId, List<Children> children) {
        Role role = roleRepo.findById(roleId).orElse(null);
        return role;
    }

    @Override
    public List<RoleDto> findRoleRights() {
        List<RoleDto> dtos = new ArrayList<>();
        List<Role> roles = roleRepo.findAll();
        roles.forEach( role -> {
            RoleDto dto = new RoleDto();
            dto.setId(role.getId());
            dto.setRoleName(role.getRoleName());
            dto.setRoleDesc(role.getRoleDesc());
            //dto.setChildrenList();

            // 分层找到这个角色的权限及其子权限
            List<Children> children = new ArrayList<>();




        });
        return null;
    }
}
