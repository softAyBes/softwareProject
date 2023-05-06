
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

    
    Scenario: adminType
    Given that admin is logged
	Then  type is admin
	
	
	Scenario: workerType
    Given that worker is logged
	Then  type is worker
	
	Scenario: customer Type
    Given that customer is logged
	Then  type is customer
	
	Scenario: get id from name
    Given that name is "admin"
	Then  id is 11
	
	Scenario: get id from name not exist
    Given that name is "habibi"
	Then  id is not valid
	
	
	