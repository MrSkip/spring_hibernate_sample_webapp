package de.m1well.spring.webapp.sample.repository;

import de.m1well.spring.webapp.sample.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author: Michael Wellner<br/>
 * date: 24.10.17<br/>
 */
public interface AppUserRepository extends JpaRepository<AppUser, String> {
    AppUser findByUsername(String username);
}