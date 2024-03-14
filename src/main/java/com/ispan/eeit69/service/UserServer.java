package com.ispan.eeit69.service;

import org.springframework.stereotype.Service;


public interface UserServer {
    boolean findByUsername(String userName);
    boolean findByPassword(String password);
    boolean findByUserAndPassword(String username,String password);
    boolean registerUser(String user,String password);
}
