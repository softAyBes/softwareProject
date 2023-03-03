@tag
Feature: create new customer

  @tag1
  Scenario: customer already exist
    Given admin want to create new customer with id "3"
    When user id "3" already exist
    Then creating customer id "3" faild
    
     @tag2
  Scenario: customer added successfully
    Given admin want to create new customer with id "7"
    When id "7" is not exist
    And admin enter id "7" Name "Beesan" phone "059960085" address "rafidya"
    Then customer id "7" added successfully
    

Scenario: update customer phone
    Given user is "customer" with id "3" want to update  phone to "05999"
    Then customer id "3" updated successfully
    
Scenario: update customer address
    Given admin want to update customer id "3" with new address "Masaken"
    Then customer address id "3" updated successfully
          
Scenario: Delete customer
    Given admin want to delete customer id "3"
    Then customer "3" deleted successfully
    
    
    
Scenario: Delete customer with invalid id
    Given admin want to delete customer id "20"
    And customer id "20" is not exist
    Then delete customer "20" faild 