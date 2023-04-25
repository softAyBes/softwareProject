Feature: generate invoice for customer.

Scenario: generate invoice successfully.
Given that the Admin is logged in is "true".
Then generate invoice to customer with id "3" and paid 500 successfully.
