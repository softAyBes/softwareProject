Feature: record full information for the product 

Scenario: record new product 
Given that admin record a product to a customer with id 1
When the product has a name "carpet" and picture "images/2019/05/silk-carpets_11171_1_1559285257.webp" and Length 4 and width 4 and material "silk"
And customer have a id 1 exist
Then record product successfully


Scenario: customer is not exist 
Given that admin record a product to a customer with id 3
When the customer with id 3 is not exist
Then record product failed 


