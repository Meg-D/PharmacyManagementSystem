package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.dto.Items;
import com.iiitb.pharmacy.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/item")
@CrossOrigin(origins = "http://localhost:3000")
public class ItemController {

    @Autowired
    private ItemService itemService;

    // add item
    @PostMapping(path="/add",consumes = "application/JSON")
    public ResponseEntity<String> addItem(@RequestBody Items item){
        return this.itemService.addItem(item);
    }

    // delete item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteItem(@PathVariable String id){
        try{
            this.itemService.deleteItem(Integer.parseInt(id));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // get all items associated with a sale id
    @GetMapping("/getall/{saleid}")
    public List<Item> getItemsBySaleId(@PathVariable String saleid){
        return this.itemService.getItemsBySaleId(Integer.parseInt(saleid));
    }
}
