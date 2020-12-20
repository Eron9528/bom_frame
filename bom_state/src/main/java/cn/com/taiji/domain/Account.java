package cn.com.taiji.domain;

import javax.persistence.*;
import java.util.Set;

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

    @ManyToMany(mappedBy = "accs")
    private Set<Role> roles;
}
