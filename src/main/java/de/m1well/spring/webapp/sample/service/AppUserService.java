package de.m1well.spring.webapp.sample.service;

import de.m1well.spring.webapp.sample.model.AppUser;

/**
 * author: Michael Wellner<br/>
 * date: 24.10.17<br/>
 */
public interface AppUserService {

    void save(AppUser appUser);

    AppUser findByUsername(String username);

}