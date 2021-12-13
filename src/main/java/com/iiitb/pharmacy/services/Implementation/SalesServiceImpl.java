package com.iiitb.pharmacy.services.Implementation;

import com.iiitb.pharmacy.beans.Customer;
import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Sale;
import com.iiitb.pharmacy.beans.User;
import com.iiitb.pharmacy.dao.CustomerDAO;
import com.iiitb.pharmacy.dao.ItemDAO;
import com.iiitb.pharmacy.dao.SaleDAO;
import com.iiitb.pharmacy.dao.UserDAO;
import com.iiitb.pharmacy.dto.Sales;
import com.iiitb.pharmacy.services.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class SalesServiceImpl implements SalesService {

    @Autowired
    private SaleDAO saleDAO;

    @Autowired
    private CustomerDAO customerDAO;

    @Autowired
    private UserDAO userDAO;

    @Autowired
    private ItemDAO itemDAO;

    // add a new Sale
    public Sale addSale(Sales sale){
        User user = userDAO.findById(sale.getUser_id()).get();
        Customer customer = customerDAO.findById(sale.getCust_id()).get();

        Sale new_sale = new Sale(0.0, 0.0,customer,user);
        return saleDAO.save(new_sale);
    }

    // generate Sale details after all the items have been added
    @Override
    public Sale makeSale(int sale_id) {

        // get sale corresponding to the given sale id
        Sale new_sale = saleDAO.findById(sale_id).get();

        // customer needs to pay. Includes discount if any
        Double bill = 0.0;

        // Actual cost (without discount)
        Double total = 0.0;

        // find all the items associated with the given sale id
        List<Item> items = itemDAO.findAllBySale_id_sale_id(new_sale);

        // calculate total and bill amount
        for(Item item: items) {
            total += item.getAmount() * item.getQuantity();
            bill += (item.getAmount() - item.getDiscount())*item.getQuantity();
        }

        new_sale.setAmount(bill);
        new_sale.setNet_diff(bill- total);

        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = formatter.format(date);
        new_sale.setDate(formattedDate);

        return saleDAO.save(new_sale);
    }


    // get list of sales made by a user
    public Optional<List<Sale>> getSaleByUserId(int userId){
        Optional<User> user = userDAO.findById(userId);
        if(!user.isEmpty()) return saleDAO.findByUser(user.get());
        return null;
    }

    // get customer's purchase history
    public Optional<List<Sale>> getSaleByCustomerNumber(String phone){
        Optional<Customer> customer = customerDAO.findByPhone(phone);
        if(!customer.isEmpty()) return saleDAO.findByCustomer(customer.get());
        return null;
    }

}
