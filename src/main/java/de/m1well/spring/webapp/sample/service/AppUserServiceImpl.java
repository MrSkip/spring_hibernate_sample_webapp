package de.m1well.spring.webapp.sample.service;

import de.m1well.spring.webapp.sample.model.AppUser;
import de.m1well.spring.webapp.sample.repository.AppAuthorityRepository;
import de.m1well.spring.webapp.sample.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;

/**
 * author: Michael Wellner<br/>
 * date: 24.10.17<br/>
 */
@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private AppAuthorityRepository appAuthorityRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(AppUser appUser) {
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));
        appUser.setAppAuthorities(new HashSet<>(appAuthorityRepository.findAll()));
        appUserRepository.save(appUser);
    }

    @Override
    public AppUser findByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}