package cn.com.taiji.domain.login;

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
    @ManyToMany
    @JoinTable(name = "ROLE_PERMISSION",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "PERMISSION_ID", referencedColumnName = "id"))
    private Set<Permission> permissions;
    @ManyToMany
    @JoinTable(name = "ROLE_ACCOUNT",
            joinColumns = @JoinColumn(name = "ROLE_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ID"))
    private Set<Account> accounts;

    public Role() {

    }

    public Role(String roleName, Set<Permission> permissions, Set<Account> accounts) {
        this.roleName = roleName;
        this.permissions = permissions;
        this.accounts = accounts;
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

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }
}
