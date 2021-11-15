package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDAO extends JpaRepository <Request,Integer> {
}
