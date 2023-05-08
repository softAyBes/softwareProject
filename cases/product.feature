
Feature: record full information for the product
Actor: customer

Scenario: record new product 
Given that the user type is "customer"
When the product has a code "01" name "mat" picture "images/2019/05/silk-carpets_11171_1_1559285257.webp" isspecial "True" status "waiting" category "carpet" Length "4" width "4" material "silk"
Then customer record product with code "01" successfully


Scenario: product already exist
Given that the user type is "customer"
When product with code "20" already exist
Then record product with code "20" is faild

Scenario: delete product 
Given that the user type is "customer"
When customer id "3" want to delete product code "20"
Then delete product "20" successfully

Scenario: delete product faild
Given that the user type is "customer"
When product code "55" is not exist
Then delete product "55" faild 

Scenario: Update product picture
Given that the user type is "customer"
When customer want to Update product "12" with new picture "/imag" 
Then product picture code "12" Update successfully

Scenario: Update product Length
Given that we want to update product "12" the new length is "30"
Then product Length code "12" Update successfully

Scenario: Update product Width
Given that we want to update product "12" the new Width is "30"
Then product Width code "12" Update successfully
