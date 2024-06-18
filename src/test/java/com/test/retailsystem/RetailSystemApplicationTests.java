package com.test.retailsystem;

import com.test.retailsystem.enums.UserType;
import com.test.retailsystem.model.Item;
import com.test.retailsystem.model.User;
import com.test.retailsystem.service.DiscountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class RetailSystemApplicationTests {
	@InjectMocks
	DiscountServiceImpl discountService;
	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void testEmployeeDiscount() {
		User user = new User(UserType.EMPLOYEE, LocalDate.now(), Arrays.asList(
				new Item("Laptop", 1000, false),
				new Item("Banana", 100, true)
		));

		double discount = discountService.calculateNetPayableAmount(user);
		assertEquals(745, discount,"User Type Employee Test Case");
	}
	@Test
	void testAffiliateDiscount() {
		User user = new User(UserType.AFFILIATE, LocalDate.now(), Arrays.asList(
				new Item("Laptop", 200, false),
				new Item("Banana", 50, true)
		));

		double expectedAmount = (200 + 50) - (0.10 * 200) - 10;
		double discount = discountService.calculateNetPayableAmount(user);
		assertEquals(expectedAmount, discount,"User Type Affiliate Test Case");
	}
	@Test
	void testCustomerDiscount() {
		LocalDate joiningDate= LocalDate.of(2022, Month.JUNE, 12);
		User user = new User(UserType.CUSTOMER, joiningDate, Arrays.asList(
				new Item("Laptop", 1000, false),
				new Item("Banana", 100, true),
				new Item("Mouse", 50, false)
		));
		double expectedAmount = (1000 + 100 + 50) - (0.05 * 1050) - 55;
		double discount = discountService.calculateNetPayableAmount(user);
		assertEquals(expectedAmount, discount,"User Type Customer Test Case");
	}
}
