package com.test.retailsystem.controller;


import com.test.retailsystem.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


public interface RetailDiscountController {
    @PostMapping(value = "retail/userDiscountCal")
    Double calculateDiscount(@RequestBody User user);
}
