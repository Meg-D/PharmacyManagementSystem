package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAO extends JpaRepository<User,Integer> {
}
