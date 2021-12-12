package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Request;
import com.iiitb.pharmacy.beans.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RequestDAO extends JpaRepository <Request,Integer> {

    @Query("SELECT r from Request r WHERE r.status=0")
    public List<Request> findAll();
}
