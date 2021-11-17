package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;

@Repository
public interface UserDAO extends JpaRepository<User,Integer> {

    User findByUsernameEqualsAndPasswordEquals(String username,String password);

    @Query("SELECT u.password FROM User u where u.username =:email")
    String getPasswordByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query ("UPDATE User u SET u.password = :newp WHERE u.username=:email")
    void updatePassword(@Param("email") String email,@Param("newp") String newp);
}
