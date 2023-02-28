#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
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

Scenario: update customer
    Given admin want to update customer with "id" and customer is exist
    When admin enter "new val" 
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
    
    
    
    
    
    