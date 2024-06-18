package com.test.retailsystem.controller;


import com.test.retailsystem.model.User;
import com.test.retailsystem.service.DiscountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RetailDiscountControllerImpl implements RetailDiscountController{

    private static final Logger LOG = LoggerFactory.getLogger(RetailDiscountControllerImpl.class);
    private final DiscountService discountService;
    @Autowired
    public RetailDiscountControllerImpl(DiscountService discountService) {
        this.discountService=discountService;
    }

    @Override
    public Double calculateDiscount(@RequestBody User user) {
        LOG.info("Calculating discount for user: {}", user.getUserType());
        return discountService.calculateNetPayableAmount(user);
    }
}
