package cn.com.taiji.domain.login;

import javax.persistence.*;

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
    @Column(name = "ACCOUNT")
    private String account;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany
    @JoinColumn(name = "ROLE_ID")
    private Role role;
    @OneToOne
    @JoinColumn(name = "USER_ID")
    private User user;

    public Account() {

    }

    public Account(String account, String password, User user, Role role) {
        this.account = account;
        this.password = password;
        this.user = user;
        this.role = role;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
