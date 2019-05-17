package cn.edu.nenu.domain;

import cn.edu.nenu.config.orm.IdEntity;
import cn.edu.nenu.util.Constants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "T_USER")
public class User extends IdEntity {
    @Column(length = 128)
    private String name;
    @Column(length = 11)
    private String telephone;
    @Column(length = 128,unique = true,nullable = false)
    private String username;
    @Column(length = 128,nullable = false)
    private String password;
    @Column(length = 36)
    private String salt;
    private LocalDateTime createAt = LocalDateTime.now();
    private Constants.Status status = Constants.Status.DISABLE;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
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

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    public void setCreateAt(LocalDateTime createAt) {
        this.createAt = createAt;
    }

}
