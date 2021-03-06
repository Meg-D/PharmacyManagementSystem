package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.dto.Items;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface ItemService {
    public ResponseEntity<String> addItem(Items item);

    public void deleteItem(int itemId);

    List<Item> getItemsBySaleId(int saleId);
}
