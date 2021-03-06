package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public interface ItemDAO extends JpaRepository<Item,Integer> {

    @Query("SELECT i from Item i WHERE i.sale_id= :saleId")
    public List<Item> findAllBySale_id_sale_id(@Param("saleId") Sale sale_id);

    @Query("SELECT i.amount from Item i WHERE i.sale_id= :saleId")
    public List<Double> findAmountBySale_id_sale_id(@Param("saleId") Sale sale_id);
}
