

Feature: Give a discount to customers 

Scenario: discount to customers successfully
Given that customer with id "3" is exist
When the price with code "12" greater than or equal "550"
Then product with code "12" get a discount of 15




