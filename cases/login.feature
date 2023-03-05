
Feature:  login feature

  Scenario: login successfully as admin
    Given that user is not logged in
    When username is "admin" which type is admin
    And password is correct "IamAdmin"
    Then  logged in successfully
    
    
    Scenario: login faild as admin
    Given that user is not logged in
    When username is "admin" which type is admin
    And password is false "wrong"
    Then  log in faild
    
    
    
    Scenario: login successfully as customer
    Given that user is not logged in
    When username is "aya" which type is customer
    And password is correct "aya123"
    Then  logged in successfully
    
    
    Scenario: login faild as customer
    Given that user is not logged in
    When username is "aya" which type is customer
    And password is false "wrong"
    Then  log in faild
    
    
    
    Scenario: login successfully as worker
    Given that user is not logged in
    When username is "jamal" which type is worker
    And password is correct "jamal123"
    Then logged in successfully

     Scenario: login faild as worker
    Given that user is not logged in
    When username is "jamal" which type is worker
    And password is false "wrong"
    Then  log in faild
