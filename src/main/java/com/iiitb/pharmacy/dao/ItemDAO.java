package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;
import java.util.Optional;

public interface ItemDAO extends JpaRepository<Item,Integer> {

    @Query("SELECT i from Item i WHERE i.sale_id= :saleId")
    public List<Item> findAllBySale_id_sale_id(@Param("saleId") Sale sale_id);
}
