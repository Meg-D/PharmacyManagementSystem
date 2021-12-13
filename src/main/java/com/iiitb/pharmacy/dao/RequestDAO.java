package com.iiitb.pharmacy.dao;


import com.iiitb.pharmacy.beans.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RequestDAO extends JpaRepository <Request,Integer> {

    @Query("SELECT r from Request r WHERE r.status=0")
    public List<Request> findAll();
}
