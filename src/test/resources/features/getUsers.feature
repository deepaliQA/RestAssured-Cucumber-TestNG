Feature: Get Users API

  Scenario: Verify user details using GET API

    Given the API endpoint is "/users/1"
    When I send a GET request
    Then the response status code should be 200
    And the response should contain first name "Emily"