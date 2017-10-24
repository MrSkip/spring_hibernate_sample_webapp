package de.m1well.spring.webapp.sample.service;

import de.m1well.spring.webapp.sample.model.AppAuthority;
import de.m1well.spring.webapp.sample.model.AppUser;
import de.m1well.spring.webapp.sample.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

/**
 * author: Michael Wellner<br/>
 * date: 24.10.17<br/>
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (AppAuthority appAuthority : appUser.getAppAuthorities()){
            grantedAuthorities.add(new SimpleGrantedAuthority(appAuthority.getName()));
        }

        return new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorities);
    }
}