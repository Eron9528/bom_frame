package cn.com.taiji.domain.login;

import javax.persistence.*;
import java.util.List;

/**
 *  用户分组。
 */

@Entity
@Table(name = "USER_GROUP")
public class UserGroup {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "GROUP_NAME")
    private String groupName;
}
