package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Medicine;
import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.dao.ItemDAO;
import com.iiitb.pharmacy.dao.MedicineDAO;
import com.iiitb.pharmacy.dao.SaleDAO;
import com.iiitb.pharmacy.dto.Items;
import com.iiitb.pharmacy.services.ItemService;
import com.iiitb.pharmacy.services.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    private MedicineService medicineService;

    // add an item
    @Override
    public ResponseEntity<String> addItem(Items item) {
        Medicine medicine = medicineDAO.findById(item.getMed_id()).get();
        Medicine db_medicine = medicineService.updateMedicineBySale(medicine, item.getQuantity());
        // quantity required is more than the stock
        if (db_medicine==null) return ResponseEntity.badRequest().body("Insufficient stock");

        Double amount = medicineDAO.findById(item.getMed_id()).get().getCost();
        Double discount = amount * item.getDiscount() * 0.01;
        Sale s = saleDAO.findById(item.getSale_id()).get();
        Item i = new Item(item.getQuantity(),amount,discount,medicine,s);
        itemDAO.save(i);

        return ResponseEntity.ok("Item added");
    }

    // delete an item
    @Override
    public void deleteItem(int id) {
        itemDAO.deleteById(id);
    }

    // get list of all the items for a given sale
    @Override
    public List<Item> getItemsBySaleId(int saleId) {
        Optional<Sale> sale = saleDAO.findById(saleId);
        List<Item> itemList = itemDAO.findAllBySale_id_sale_id(sale.get());
        return itemList;
    }
}
