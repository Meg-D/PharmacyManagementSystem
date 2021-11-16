package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.services.ItemService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Override
    public Item addItem(Item item) {
        return null;
    }

    @Override
    public void deleteItem(int parseInt) {

    }

    @Override
    public List<Item> getItemsBySaleId(int itemId) {
        return null;
    }
}
