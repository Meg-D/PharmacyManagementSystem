package com.iiitb.pharmacy.controller;

import com.iiitb.pharmacy.beans.Item;
import com.iiitb.pharmacy.beans.Transaction;
import com.iiitb.pharmacy.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins ="*")
public class ItemController {
    @Autowired
    public ItemService itemService;

    //add item
    @PostMapping(path="/item",consumes = "application/JSON")
    public Item addItem(@RequestBody Item item){
        return this.itemService.addItem(item);
    }

    //delete item
    @DeleteMapping("/item/{itemid}")
    public ResponseEntity<HttpStatus> deleteArtist(@PathVariable String itemId){
        try{
            this.itemService.deleteItem(Integer.parseInt(itemId));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
