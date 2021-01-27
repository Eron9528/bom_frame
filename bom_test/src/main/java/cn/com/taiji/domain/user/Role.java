package cn.com.taiji.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

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
    @Column(name = "ROLE_NAME")
    private String roleName;
    @Column(name = "ROLE_DESC")
    private String roleDesc;
    @ManyToMany
    @JoinTable(name = "ROLE_PERMISSION",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "id"))
    @JsonIgnore
    private Set<Permission> permissions;
    @ManyToMany
    @JoinTable(name = "ROLE_USER",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID"))
    @JsonIgnore
    private Set<User> users;

    public Role() {

    }

    public Role(String roleName, Set<Permission> permissions, Set<User> users) {
        this.roleName = roleName;
        this.permissions = permissions;
        this.users = users;
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

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<Permission> permissions) {
        this.permissions = permissions;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }
}
