package cn.com.taiji.domain.login;

import javax.persistence.*;
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
    private long id;
    @Column(name = "PERMISSION_NAME")
    private String permissionName;
    @Column(name = "MENU")
    private String menu;
    @ManyToMany(mappedBy = "permissions")
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
}
