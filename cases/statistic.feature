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
Feature: statistic

  
  Scenario: total number of items
    Given I want to check the total number of items
    Then total number sent

  
  Scenario: total number of Money
    Given I want to check the total number of Money
    Then total Money sent
    
   
  Scenario: total number of debts
    Given I want to check the total number of debts
    Then total debts sent
    
   
  Scenario: total number of inTretment products
    Given I want to check the total inTretment products
    Then total inTretment products sent

       
  Scenario: total number of waiting products
    Given I want to check the total waiting products
    Then total waiting products sent