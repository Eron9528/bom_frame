package cn.com.taiji.service.user;

import cn.com.taiji.domain.rightsTree.Children;
import cn.com.taiji.domain.user.Permission;
import cn.com.taiji.domain.user.Role;
import cn.com.taiji.dto.User.RoleDto;

import java.util.List;

public interface RoleService {
    List<RoleDto> findAll();

    Role addRole(Role role);

    Role findById(long id);

    Role updateRoleById(long id, Role role);

    Role deleteRoleById(long id);

    /**
     * @描述   角色页面展开层，通过点击叉号来删除角色的权限，如果删除的权限有子权限，则删除所有
     * @创建人 Mayu
     * @创建时间 2021/1/28
    */
    Permission deleteRoleRightById(long rightId,long roleId);

    /**
     * @描述    点击分配权限按钮弹出本角色所占有的树型结构
     * @创建人 Mayu
     * @创建时间 2021/1/28
    */
    List<Children> findRoleRightsById(long roleId);

    /**
     * @描述    根据选择的权限重新为roleId 进行赋值
     * @创建人 Mayu
     * @创建时间 2021/1/28
    */
    Role updateRights(long roleId, List<Children> children);

    /**
     * @Author: Eron
     * @Description:   权限页面刷新点击扩展按钮下的所有权限
     * @Date: 23:43 2021/1/29
     */
    List<RoleDto> findRoleRights();
}
