# retailManagement
This project is a Java Spring Boot application that calculates the net payable amount for a bill based on various discount rules. The project emphasizes object-oriented programming principles and includes unit tests for good code coverage and mocking.

## Discounts
- **Employee Discount**: 30%
- **Affiliate Discount**: 10%
- **Customer Discount**: 5% (if the customer has been with the store for over 2 years)
- **Bill Discount**: For every $100 on the bill, there is a $5 discount
- **Note**: Percentage-based discounts do not apply to groceries, and only one of the percentage-based discounts can be applied.

## Project Structure
- `model`: Contains the data model classes (`Item`, `User`, `UserType`).
- `service`: Contains the service class (`DiscountCalculator`) that calculates the net payable amount.
- `test`: Contains unit tests for the service class.

## Prerequisites
- JDK 17 
- Maven 3.9.6

## Getting Started

### Cloning the Repository
```bash
cd retailSystem
git clone https://github.com/AnkitaRananaware/retailManagement.git
mvn clean install
mvn clean install spring-boot:run
