package com.iiitb.pharmacy.dao;

import com.iiitb.pharmacy.beans.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemDAO extends JpaRepository<Item,Integer> {
}
