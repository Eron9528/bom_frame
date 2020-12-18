package cn.com.taiji.domain.login;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 权限表   权限名称，进行曾删改查
 */

public class Permission {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "PERMISSION_NAME")
    private String permissionName;
    @Column(name = "SELECT")
    private boolean select;
    @Column(name = "ADD")
    private boolean add;
    @Column(name = "UPDATE")
    private boolean update;
    @Column(name = "DEL")
    private boolean del;

}
