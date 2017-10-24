package de.m1well.spring.webapp.sample.service;

/**
 * author: Michael Wellner<br/>
 * date: 24.10.17<br/>
 */
public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

}