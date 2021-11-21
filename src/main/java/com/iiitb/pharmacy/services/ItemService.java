package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.dto.Items;

import java.util.List;

public interface ItemService {
    public Item addItem(Items item);

    public void deleteItem(int itemId);

    List<Item> getItemsBySaleId(int saleId);
}
