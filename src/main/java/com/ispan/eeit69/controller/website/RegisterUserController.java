package com.ispan.eeit69.controller.website;

import com.ispan.eeit69.DTO.UserDTO;
import com.ispan.eeit69.service.Impl.UserServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class RegisterUserController {

    @Autowired
    private UserServerImpl userServer;

    @PostMapping(value = "/registerUser", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkUsernameAndpassword(@RequestBody UserDTO loginForm, HttpSession session) { // 注入HttpSession
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        Map<String, Object> loginResponse = new HashMap<>();
        if (userServer.registerUser(username,password)){
            System.out.println("使用者註冊成功controller");
            String errorMessage = "使用者註冊成功";
            loginResponse.put("exists", true);
            loginResponse.put("message", errorMessage);
            loginResponse.put("redirect", "login.html");  // 指定跳轉頁面的路徑
            return ResponseEntity.ok(loginResponse);
        }else {
            System.out.println("使用者註冊失敗");
            String errorMessage = "使用者註冊失敗";
            loginResponse.put("exists", false);
            loginResponse.put("message", errorMessage);
            return ResponseEntity.ok(loginResponse);
        }
    }
}
