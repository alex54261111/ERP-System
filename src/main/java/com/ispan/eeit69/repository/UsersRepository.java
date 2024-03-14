package com.ispan.eeit69.repository;

import com.ispan.eeit69.model.UserTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface UsersRepository extends JpaRepository <UserTable,Long>{
    UserTable findByUsername(String username);
    UserTable findByPassword(String password);
    @Query("SELECT password FROM UserTable WHERE username = :username")
    String  findByUserAndPassword(@Param("username") String username);
}
