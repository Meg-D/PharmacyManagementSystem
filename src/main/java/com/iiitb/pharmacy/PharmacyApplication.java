package com.iiitb.pharmacy;

import com.iiitb.pharmacy.beans.*;
import com.iiitb.pharmacy.dao.*;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class PharmacyApplication {

    @Autowired
    UserDAO userDAO;

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    MedicineDAO medicineDAO;

    @Autowired
    RequestDAO requestDAO;

    @Autowired
    VendorDAO vendorDAO;

    @Autowired
    TransactionDAO transactionDAO;

    @Autowired
    SaleDAO saleDAO;

    @Autowired
    ItemDAO itemDAO;

    public static void main(String[] args) {
        SpringApplication.run(PharmacyApplication.class, args);
    }

    @Bean
    InitializingBean App(){
        return () ->
        {
            User user1 = userDAO.save(new User(1,"Messi","psg","7746068233","Paris, France"));
            User user2 = userDAO.save(new User(2,"Ronaldo","juve","7575038731","Rome, Italy"));
            User user3 = userDAO.save(new User(3,"Neymar","psg","7002673946","Paris, France"));

            Vendor vendor1 = vendorDAO.save(new Vendor(1,"Light Yagami","Yokohama","28/02/1986 10:31:25","lightyagami@deathnote.com","098"));
            Vendor vendor2 = vendorDAO.save(new Vendor(2,"Okabe Rintaru","Kyoto","07/10/2001 21:40:08","okaberintaru@steinsgate.com","098"));
            Vendor vendor3 = vendorDAO.save(new Vendor(3,"Itachi Uchiha","Osaka","09/06/1998 12:06:23","itachiuchiha@akatsuki.com","098"));
            Vendor vendor4 = vendorDAO.save(new Vendor(4,"Itadori Yuuji","Nagoya","20/03/2006 15:40:20","itadoriyuuji@jjk.com","098"));
            Vendor vendor5 = vendorDAO.save(new Vendor(5,"Kaneki Ken","Tokyo","20/10/1994 04:10:55","kanekiken@tokyoghoul.com","098"));

            Medicine medicine1 = medicineDAO.save(new Medicine(1,"Paracetamol",35,12.0));
            Medicine medicine2 = medicineDAO.save(new Medicine(2,"Ibuprofen",5,30.0));
            Medicine medicine3 = medicineDAO.save(new Medicine(3,"Chlorphenamine",10,24.0));
            Medicine medicine4 = medicineDAO.save(new Medicine(4,"Ranitidine",20,36.0));
            Medicine medicine5 = medicineDAO.save(new Medicine(5,"Hydrocortisone",10,42.0));
            Medicine medicine6 = medicineDAO.save(new Medicine(6,"Savlon",5,6.0));
            Medicine medicine7 = medicineDAO.save(new Medicine(7,"Cetirizine",40,32.0));
            Medicine medicine8 = medicineDAO.save(new Medicine(8,"Benadryl",10,17.0));
            Medicine medicine9 = medicineDAO.save(new Medicine(9,"Limcee",60,5.0));
            Medicine medicine10 = medicineDAO.save(new Medicine(10,"Cephalexin",20,83.0));

            Customer customer1 = customerDAO.save(new Customer(1,"RM","1212121212",1));
            Customer customer2 = customerDAO.save(new Customer(2,"JK","1919191919",1));
            Customer customer3 = customerDAO.save(new Customer(3,"J-Hope","1818181818",1));
            Customer customer4 = customerDAO.save(new Customer(4,"Jimin","1313131313",1));
            Customer customer5 = customerDAO.save(new Customer(5,"Suga","9393939393",1));
            Customer customer6 = customerDAO.save(new Customer(6,"Jin","4444444444",1));
            Customer customer7 = customerDAO.save(new Customer(7,"V","3030303030",1));

            requestDAO.save(new Request("Aspirin",25,0,"30/10/2021 19:20:21",user1));
            requestDAO.save(new Request(2,"Savlon",25,1,"07/11/2021 12:20:13","21/11/2021 19:21:23",user1,user1,vendor1));
            requestDAO.save(new Request("Bacampicillin",20,0,"08/11/2021 08:45:21",user2));
            requestDAO.save(new Request("Hydroxycholoquine",75,0,"20/09/2021 02:30:56",user3));
            requestDAO.save(new Request(5,"Limcee",80,1,"18/11/2021 17:34:39","30/11/21 05:45:57",user3,user2,vendor1));
            requestDAO.save(new Request(6,"Paracetamol",45,1,"04/12/2021 20:20:20","06/12/2021 06:16:26",user2,user1,vendor2));

            transactionDAO.save(new Transaction(35,10.0,"10/08/2021 19:20:21",medicine1,vendor3,user1));
            transactionDAO.save(new Transaction(20,30.0,"19/09/2021 07:08:09",medicine2,vendor1,user2));
            transactionDAO.save(new Transaction(40,17.0,"20/09/2021 10:10:10",medicine5,vendor2,user3));
            transactionDAO.save(new Transaction(50,80.0,"30/10/2021 12:35:59",medicine7,vendor5,user2));
            transactionDAO.save(new Transaction(65,42.0,"03/11/2021 06:34:22",medicine3,vendor4,user3));

            Sale sale1 = saleDAO.save(new Sale(1,94.23,8.0,"03/11/2021 06:34:22",customer1,user1));
            Sale sale2 = saleDAO.save(new Sale(2,94.23,-6.0,"04/11/2021 08:34:22",customer2,user2));
            Sale sale3 = saleDAO.save(new Sale(3,94.23,0.0,"05/11/2021 10:34:22",customer3,user3));
            Sale sale4 = saleDAO.save(new Sale(4,94.23,13.0,"06/11/2021 03:34:22",customer4,user1));
            Sale sale5 = saleDAO.save(new Sale(5,94.23,2.2,"07/11/2021 02:34:22",customer5,user2));
            Sale sale6 = saleDAO.save(new Sale(6,94.23,-4.0,"08/11/2021 07:34:22",customer6,user3));
            Sale sale7 = saleDAO.save(new Sale(7,94.23,0.0,"09/11/2021 13:34:22",customer7,user1));
            Sale sale8 = saleDAO.save(new Sale(8,94.23,4.1,"10/11/2021 15:34:22",customer1,user2));
            Sale sale9 = saleDAO.save(new Sale(9,94.23,-7.0,"16/11/2021 17:34:22",customer2,user3));
            Sale sale10 = saleDAO.save(new Sale(10,94.23,0.0,"20/11/2021 19:34:22",customer3,user1));
            Sale sale11 = saleDAO.save(new Sale(11,94.23,7.0,"23/11/2021 21:34:22",customer4,user2));
            Sale sale12 = saleDAO.save(new Sale(12,94.23,-1.0,"28/11/2021 21:34:22",customer5,user3));

            itemDAO.save(new Item(1,2,4.0,0.0,medicine1,sale1));
            itemDAO.save(new Item(2,3,4.0,1.0,medicine2,sale1));
            itemDAO.save(new Item(3,4,4.0,0.0,medicine3,sale2));
            itemDAO.save(new Item(4,1,5.0,3.0,medicine4,sale2));
            itemDAO.save(new Item(5,7,4.0,0.0,medicine5,sale2));
            itemDAO.save(new Item(6,2,7.0,0.0,medicine6,sale3));
            itemDAO.save(new Item(7,9,4.0,0.0,medicine7,sale3));
            itemDAO.save(new Item(8,10,4.0,0.0,medicine8,sale4));
            itemDAO.save(new Item(9,2,4.0,7.0,medicine9,sale4));
            itemDAO.save(new Item(10,1,41.0,0.0,medicine10,sale6));
            itemDAO.save(new Item(11,1,9.0,0.0,medicine1,sale7));
            itemDAO.save(new Item(12,5,2.0,5.0,medicine2,sale8));
            itemDAO.save(new Item(13,6,5.0,0.0,medicine3,sale9));
            itemDAO.save(new Item(14,1,91.0,0.0,medicine4,sale9));
            itemDAO.save(new Item(15,2,4.0,4.1,medicine5,sale10));
            itemDAO.save(new Item(16,3,17.0,0.0,medicine6,sale10));
            itemDAO.save(new Item(17,4,4.0,8.0,medicine7,sale10));
            itemDAO.save(new Item(18,6,12.0,0.0,medicine8,sale11));
            itemDAO.save(new Item(19,8,39.0,10.0,medicine9,sale12));
            itemDAO.save(new Item(20,9,25.0,0.0,medicine10,sale12));

        };
    }
}
