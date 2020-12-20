package cn.com.taiji.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ROLE")
public class Role {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "ROLE_NAME")
    private String roleName;

//    @ManyToMany(mappedBy = "roles")
//    @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//    @JsonIgnore
//    private Set<Users> users = new HashSet<>();

    @ManyToMany
//  @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "role_permission",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "per_id", referencedColumnName = "ID"))
    private Set<Permission> pers;

    @ManyToMany
//  @Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
    @JoinTable(name = "role_account",
            joinColumns = @JoinColumn(name = "role_id", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "acc_id", referencedColumnName = "ID"))
    private Set<Account> accs;


    //.....getter setter tostring省略
}

