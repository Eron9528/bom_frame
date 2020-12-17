package cn.com.taiji.domain.login;

import javax.persistence.*;

@Entity
@Table(name="USER")
public class User {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "CCCC", nullable=false)
    private String cccc;
    @Column(name = "NAME", nullable=false)
    private String name;
    @Column(name = "AGE", nullable=true)
    private Integer age;
    @Column(name = "GENDER", nullable=true)
    private boolean gender;
    @Column(name = "PHONE_NUMBER", nullable=true)
    private String phoneNumber;
    @Column(name = "EMAIL", nullable=true)
    private String email;

    public User() {

    }

    public User(String cccc, String name, Integer age, boolean gender, String phoneNumber, String email) {
        this.cccc = cccc;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCccc() {
        return cccc;
    }

    public void setCccc(String cccc) {
        this.cccc = cccc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
