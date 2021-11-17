package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.dao.ItemDAO;
import com.iiitb.pharmacy.dao.SaleDAO;
import com.iiitb.pharmacy.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Autowired
    private SaleDAO saleDAO;

    @Override
    public Item addItem(Item item) {
        itemDAO.save(item);
        return item;
    }

    @Override
    public void deleteItem(int id) {
        itemDAO.deleteById(id);
    }

    @Override
    public List<Item> getItemsBySaleId(int saleId) {
        Optional<Sale> sale = saleDAO.findById(saleId);
        List<Item> itemList = itemDAO.findAllBySale_id_sale_id(sale.get());
        return itemList;
    }
}
