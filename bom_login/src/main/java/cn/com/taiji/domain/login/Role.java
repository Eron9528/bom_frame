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
    @OneToOne
    @JoinColumn(name = "PERMISSION_ID")
    private Permission permission;
}
