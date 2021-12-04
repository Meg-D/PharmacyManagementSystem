package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Medicine;
import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.dao.CustomerDAO;
import com.iiitb.pharmacy.dao.ItemDAO;
import com.iiitb.pharmacy.dao.MedicineDAO;
import com.iiitb.pharmacy.dao.SaleDAO;
import com.iiitb.pharmacy.dto.Items;
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

    @Autowired
    private MedicineDAO medicineDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public Item addItem(Items item) {
        Medicine m = medicineDAO.findById(item.getMed_id()).get();
        Double amount = medicineDAO.findById(item.getMed_id()).get().getCost() * 0.8;
        Customer c = customerDAO.findById(item.getCust_id()).get();
        Sale s = saleDAO.findById(item.getSale_id()).get();
        Item i = new Item(item.getQuantity(),amount,item.getDiscount(),m,c,s);
        return itemDAO.save(i);
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
