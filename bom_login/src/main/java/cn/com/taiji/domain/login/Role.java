package cn.com.taiji.domain.login;

import javax.persistence.*;

/**
 *   角色表：   用户新建
 */
@Entity
@Table(name = "ROLE")
public class Role {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String roleName;
    @ManyToMany
    @JoinColumn(name = "PERMISSION_ID")
    private Permission permission;

    public Role() {

    }

    public Role(String roleName, Permission permission) {
        this.roleName = roleName;
        this.permission = permission;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }
}
