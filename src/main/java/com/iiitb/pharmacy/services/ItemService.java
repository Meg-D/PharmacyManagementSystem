package com.iiitb.pharmacy.services;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Transaction;

public interface ItemService {
    public Item addItem(Item item);

    public void deleteItem(int parseInt);
}
