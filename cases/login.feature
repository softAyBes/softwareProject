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
Feature:  login feature

  @tag1
  Scenario: login successfully
    Given that admin is not logged in
    When user is "admin"
    And password is "IamAdmin"
    Then admin logged in successfully

  @tag2
  Scenario: login failed
   Given that the admin is not logged in
		When user is "admin"
		And password is "false"
    Then login failed
