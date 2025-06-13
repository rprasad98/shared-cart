package com.example.demo.contoller;

import com.example.demo.Service.impl.CartItemsService;
import com.example.demo.dto.AddItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartApplication {

    @Autowired
    private CartItemsService cartItemsService;

    @PostMapping("/addItems/{cartId}")
    public Boolean addItem(@PathVariable String cartId, @RequestBody AddItem itemAdd){


      return true;
    }


}
