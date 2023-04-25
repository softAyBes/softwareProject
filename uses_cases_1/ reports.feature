Feature: generate customized reports about business.

Scenario: Admin wants to generate customers details report.
Given: that the Admin is logged in is "true" now.
Then Admin generated all customers details report successfully.


Scenario: Admin can not generate report.
Given that the admin is not logged in is "false" now
Then the report  generated failed.


Scenario: Admin wants to generate worker details report.
Given: that the Admin is logged in is "true" now.
Then Admin generated all worker details report successfully.
