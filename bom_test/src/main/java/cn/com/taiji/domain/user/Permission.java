package cn.com.taiji.domain.user;

import cn.com.taiji.domain.rightsTree.interfaces.TreeFid;
import cn.com.taiji.domain.rightsTree.interfaces.TreeId;
import cn.com.taiji.dto.User.PermissionDto;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * 权限表   权限名称，进行曾删改查
 */
@Entity
@Table(name = "PERMISSION")
public class Permission {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TreeId
    private long id;
    @Column(name = "PERMISSION_NAME")
    private String permissionName;
    @Column(name = "MENU")
    private String menu;
    @Column(name = "LAYER")
    private int layer;
    @TreeFid
    @Column(name = "UP_ID")
    private long upId;      //  上级id
    @Column(name = "HAS_CHILD")
    private boolean hasChild;

    @ManyToMany(mappedBy = "permissions")
    @JsonIgnore
    private Set<Role> roles;

    public Permission() {
    }

    public Permission(String permissionName, String menu, Set<Role> roles) {
        this.permissionName = permissionName;
        this.menu = menu;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public long getUpId() {
        return upId;
    }

    public void setUpId(long upId) {
        this.upId = upId;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public void setHasChild(boolean hasChild) {
        this.hasChild = hasChild;
    }

}
