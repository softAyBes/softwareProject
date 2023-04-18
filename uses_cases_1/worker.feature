@tag
Feature: Worker

  @tag1
  Scenario: Update product status
  Given that worker want to update status to "in treatment" of product code "100" which is for customer id "3"
  Then product updated to "in treatment" successfully
