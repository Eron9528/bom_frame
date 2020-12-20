package cn.com.taiji.domain.login;

import javax.persistence.*;
import java.util.Set;

/**
 *   注册账号， 包括账号的名称和密码。 登录后可以配置个人信息，个人信息保存在User 类
 */

@Entity
@Table(name = "ACCOUNT")
public class Account {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany(mappedBy = "accounts")
    private Set<Role> roles;

    public Account() {

    }

    public Account(String username, String password,Set<Role> roles) {
        this.username = username;
        this.password = password;
 //       this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
