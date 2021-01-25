package cn.com.taiji.service.user;

import cn.com.taiji.domain.rightsTree.Children;
import cn.com.taiji.domain.rightsTree.Tree;
import cn.com.taiji.domain.user.Permission;
import cn.com.taiji.dto.User.PermissionDto;

import java.util.List;

public interface PermissionService {

    List<Permission> findAll();
    /**
     * @Author: Eron
     * @Description: 这个返回的数据没有和element tree 绑定上，弃用了，改用findTree. 在后台直接拼成element tree 需要的格式
     * @Date: 20:43 2021/1/23
     */
    Tree<Permission> findRightsTree();

    List<Children> findTree();

    /**
     * @Author: Eron
     * @Description: 根据用户点击权限树找到对应的子菜单
     * @Date: 23:31 2021/1/23
     */
    List<Permission> findChildrenByMenuId(long menuId);

    /**
     * @Author: Eron
     * @Description: 返回第一层的数据
     * @Date: 0:07 2021/1/24
     */
    List<Permission> findFirstLayer();

    /**
     * @Author: Eron
     * @Description:  根据 上级id 添加新的权限
     * @Date: 22:00 2021/1/24
     */
    Permission addNode(long menuId, Permission permission);

    /**
     * @描述 修改节点信息
     * @创建人 Mayu
     * @创建时间 2021/1/25
    */
    Permission editNode(long id, Permission permission);

    /**
     * @描述   删除所选节点
     * @创建人 Mayu
     * @创建时间 2021/1/25
    */
    Permission deleteById(long id);
}
