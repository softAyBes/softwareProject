
@tag
Feature: Distribute produts

  @tag1
  Scenario: distibute product
    Given worker id "13" has the least number of products in treatment
    Then new order added to him 
    
  Scenario: delete product
    Given product id "20" for worker id "7" deleted
    Then product deleted successfully