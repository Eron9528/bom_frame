package cn.com.taiji.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "PERMISSION")
public class Permission implements Serializable {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "PERMISSION_NAME")
    private String permissionName;
    @Column(name = "MENU")
    private String menu;
    @ManyToMany(mappedBy = "pers")
    private Set<Role> roles;

}