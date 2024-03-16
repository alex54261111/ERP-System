package com.ispan.eeit69.controller.website;

import com.ispan.eeit69.DTO.UserDTO;
import com.ispan.eeit69.model.UserTable;
import com.ispan.eeit69.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class ResuFulAPIController {

    @Autowired
    private UsersRepository usersRepository;
    private List<UserDTO> users = new ArrayList<>();

    // GET /users
    @GetMapping
    public List<UserTable> getAllUsers() {
        return usersRepository.findAll();
    }

    // GET /users/{id}
    @GetMapping("/{id}")
    public UserDTO getUserById(@PathVariable int id) {
        for (UserDTO user : users) {
            if (user.getId() == id) {
                return user;
            }
            System.out.println(users);
        }
        return null; // 返回null表示未找到該用戶
    }

    // POST /users
    @PostMapping
    public UserDTO createUser(@RequestBody UserDTO newUser) {
        users.add(newUser);
        return newUser;
    }

    // PUT /users/{id}
    @PutMapping("/{id}")
    public UserDTO updateUser(@PathVariable int id, @RequestBody UserDTO updatedUser) {
        for (UserDTO user : users) {
            if (user.getId() == id) {
                user.setUsername(updatedUser.getUsername());
                user.setPassword(updatedUser.getPassword());
                return user;
            }
        }
        return null; // 返回null表示未找到該用戶
    }

    // DELETE /users/{id}
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        users.removeIf(user -> user.getId() == id);
    }
}
