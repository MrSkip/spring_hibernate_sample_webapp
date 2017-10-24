package de.m1well.spring.webapp.sample.model;

import javax.persistence.*;
import java.util.Set;

/**
 * author: Michael Wellner<br/>
 * date: 24.10.17<br/>
 */
@Entity
@Table(name = "app_users")
public class AppUser {

    private String uuid;
    private String username;
    private String password;
    private String passwordConfirm;
    private Set<AppAuthority> appAuthorities;

    public String getUuidd() {
        return uuid;
    }

    public void setUuidd(String uuid) {
        this.uuid = uuid;
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

    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }

    @ManyToMany
    @JoinTable(name = "app_user_authorities", joinColumns = @JoinColumn(name = "app_user"), inverseJoinColumns = @JoinColumn(name = "app_authority"))
    public Set<AppAuthority> getAppAuthorities() {
        return appAuthorities;
    }

    public void setAppAuthorities(Set<AppAuthority> appAuthorities) {
        this.appAuthorities = appAuthorities;
    }

    @Override
    public String toString() {
        return "AppUser{" +
                "uuid='" + uuid + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", passwordConfirm='" + passwordConfirm + '\'' +
                ", appAuthorities=" + appAuthorities +
                '}';
    }
}
