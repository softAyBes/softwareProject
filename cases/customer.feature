@tag
Feature: create new customer


  @tag1
  Scenario: customer already exist
    Given admin want to create new customer with id "3"
    When user id "3" already exist
    Then creating faild

  @tag2
  Scenario: customer added successfully
    Given admin want to create new customer with id "3"
    When "3" is not exist
    And admin enter "id","name","phone","address"
    Then customer added successfully

Scenario: update customer phone
    Given admin want to update customer id "3" with new phone 0599
    Then customer updated successfully
    
Scenario: update customer address
    Given admin want to update customer id "3" with new address "Rafidya"
    Then customer updated successfully
    
Scenario: Delete customer
    Given admin want to delete 
    When enter the customer id "3"
    Then customer "3" deleted successfully
    
  
  Scenario: Delete customer
    Given admin want to delete 
    When enter the customer id "3" 
    And customer id "3" is not exist
    Then delete customer "3" faild 
    
    
    
    
    
    