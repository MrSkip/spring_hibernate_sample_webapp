package de.m1well.spring.webapp.sample.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

/**
 * author: Michael Wellner<br/>
 * date: 24.10.17<br/>
 */
@Entity
@Table(name = "app_authorities")
public class AppAuthority {

    private String uuid;
    private String name;
    private Set<AppUser> appUsers;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "appAuthority")
    public Set<AppUser> getAppUsers() {
        return appUsers;
    }

    public void setAppUsers(Set<AppUser> appUsers) {
        this.appUsers = appUsers;
    }

    @Override
    public String toString() {
        return "AppAuthority{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", appUsers=" + appUsers +
                '}';
    }
}
