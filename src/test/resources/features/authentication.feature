Feature: Authentication API

  Scenario: Verify authenticated user details

    Given I create an authenticated API request
    When I send a GET request to "/auth/me"
    Then the response status code should be 200
    And the response should contain username "emilys"
    
