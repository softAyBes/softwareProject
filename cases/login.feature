

Feature:  login feature

  Scenario: login successfully
    Given that admin is not logged in
    When user is "admin"
    And password is "IamAdmin"
    Then admin logged in successfully

  Scenario: login failed
    Given that admin is not logged in
		When user is "admin"
		And password is "wrong"
    Then login failed
