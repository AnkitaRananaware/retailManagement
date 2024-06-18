package com.test.retailsystem.service;
import com.test.retailsystem.model.Item;
import com.test.retailsystem.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService{
    private static final double EMPLOYEE_DISCOUNT = 0.30;
    private static final double AFFILIATE_DISCOUNT = 0.10;
    private static final double CUSTOMER_DISCOUNT = 0.05;
    private static final double DISCOUNT_PER_100 = 5.0;
    private static final Logger LOG = LoggerFactory.getLogger(DiscountServiceImpl.class);
    @Override
    public double calculateNetPayableAmount(User user) {
        try {
            if (user == null || user.getItems() == null || user.getItems().isEmpty()) {
                throw new IllegalArgumentException("User or items is null or empty.");
            }
            double totalAmount = 0;
            double totalBillAmount = calculateTotalBill(user.getItems());
            double percentageDiscount = calculatePercentageBasedDiscount(user);
            double defautDiscount = defaultDiscount(totalBillAmount);
            totalAmount = totalBillAmount - percentageDiscount - defautDiscount;
            return totalAmount;
        } catch (IllegalArgumentException e) {
            LOG.error("Error calculating net payable amount:%s", e.getMessage());
            return 0;
        } finally {
            LOG.info("Final Discount Calculated");
        }
    }

    private static double calculatePercentageBasedDiscount(User user) {
        double discountAmount=0;
        double amount = calculateNonGroceryAmount(user.getItems());
        var userType=user.getUserType();
        switch (userType) {
            case EMPLOYEE:
                discountAmount += (amount) * EMPLOYEE_DISCOUNT;
                break;
            case AFFILIATE:
                discountAmount += (amount) * AFFILIATE_DISCOUNT;
                break;
            case CUSTOMER:
                if (ChronoUnit.YEARS.between(user.getJoiningDate(), LocalDate.now()) >= 2) {
                    discountAmount += (amount) * CUSTOMER_DISCOUNT;
                }
                break;
        }
        return discountAmount;
    }
    private static double calculateNonGroceryAmount(List<Item> items) {
        return items.stream()
            .filter(item -> !item.isGrocery())
            .mapToDouble(Item::getPrice)
            .sum();
    }
    private static double calculateTotalBill(List<Item> items) {
        return items.stream().mapToDouble(Item::getPrice).sum();
    }
    private static double defaultDiscount(double totalAmount) {
        return (int) (totalAmount / 100) * DISCOUNT_PER_100;
    }
}
