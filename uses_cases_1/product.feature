
Feature: record full information for the product
Actor: customer

Scenario: record new product 

Given that the user type is "customer"
When the product has a code "01" name "mat" picture "images/2019/05/silk-carpets_11171_1_1559285257.webp" isspecial "True" status "waiting" category "carpet" Length "4" width "4" material "silk"
Then customer record product with code "01" successfully


Scenario: product already exist
Given that the user type is "customer"
When product with code "01" already exist
Then record product with code "01" is faild

