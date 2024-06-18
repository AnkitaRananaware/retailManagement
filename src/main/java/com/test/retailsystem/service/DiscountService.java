package com.test.retailsystem.service;

import com.test.retailsystem.model.User;
import org.springframework.stereotype.Component;

@Component
public interface DiscountService {
     double calculateNetPayableAmount(User user);
}
