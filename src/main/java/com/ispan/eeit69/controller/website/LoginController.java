package com.ispan.eeit69.controller.website;

import com.ispan.eeit69.service.Impl.UserServerImpl;
import com.ispan.eeit69.DTO.UserDTO;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;  // 引入 HttpSession
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private UserServerImpl userServer;
    @PostMapping(value = "/checkUsernameAndPassword", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> checkUsernameAndpassword(@RequestBody UserDTO loginForm, HttpSession session) { // 注入HttpSession
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        // 返回响应
        Map<String, Object> loginResponse = new HashMap<>();
        if (userServer.findByUserAndPassword(username,password)){
            System.out.println("使用者查詢成功");
            String errorMessage = "使用者查詢成功";// "帳號或密碼錯誤"
            loginResponse.put("exists", true);
            loginResponse.put("message", errorMessage);
            loginResponse.put("redirect", "loginOk");  // 指定跳轉頁面的路徑
            return ResponseEntity.ok(loginResponse);
        }else {
            System.out.println("使用者查詢失敗，密碼或帳號錯誤");
            String errorMessage = "使用者查詢失敗，密碼或帳號錯誤";// "帳號或密碼錯誤"
            loginResponse.put("exists", false);
            loginResponse.put("message", errorMessage);
            return ResponseEntity.ok(loginResponse);
        }
    }
}



