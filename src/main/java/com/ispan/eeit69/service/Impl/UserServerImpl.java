package com.ispan.eeit69.service.Impl;

import com.ispan.eeit69.model.UserTable;
import com.ispan.eeit69.repository.UsersRepository;
import com.ispan.eeit69.service.UserServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service//解決Autowired members must be defined in valid Spring bean (@Component|@Service|...)
public class UserServerImpl implements UserServer {
    @Autowired
    private UsersRepository userRepo;
    UserTable newUser = new UserTable();

    @Override
    public boolean findByUsername(String username) {
        UserTable finUserName = userRepo.findByUsername(username);
        if(finUserName!=null){
            System.out.println("使用者名稱存在Sevice");
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean findByPassword(String password) {
        UserTable finPassword = userRepo.findByPassword(password);
        if(finPassword!=null){
            System.out.println("使用者密碼存在Sevice");
            return true;
        }else {
            return false;
        }
    }
    @Override
    public boolean findByUserAndPassword(String username, String password) {
        UserTable finUser = userRepo.findByUsername(username);
        if(finUser!=null){
            System.out.println("使用者名稱存在Sevice");
            String finPassword = userRepo.findByUserAndPassword(username);
            if (Objects.equals(password, finPassword)){
                System.out.println("使用者名稱和密碼存在Sevice");
                return true;
            }
        }
        System.out.println("使用者名稱查詢失敗evice");
        return false;
    }

    @Override
    public boolean registerUser(String user, String password) {
       if(!findByUsername(user)){
           System.out.println("開始註冊Impl");
           newUser.setUsername(user);
           newUser.setPassword(password);
           userRepo.save(newUser);
           return true;
       }else {
           System.out.println("帳號重複");
           return false;
       }
    }
}
