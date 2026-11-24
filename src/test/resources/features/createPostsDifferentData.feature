Feature: Create Post with ScenarioOutline and DataTablle with 

Scenario Outline: Create posts with different data

  Given I prepare a public API request
  And I create a post request with title "<title>" and body "<body>" for user <userId>
  When I execute "POST" request to "/posts/add"
  Then the response status code should be 201
  And the response should contain title "<title>"

Examples:
  | title       | body                  | userId |
  | Java        | Learning Java         | 1      |
  | Selenium    | Learning Selenium     | 2      |
  | RestAssured | Learning API Testing  | 3      |
  
  
  Scenario: Create post using DataTable

  Given I prepare a public API request

  And I create a post using following data
    | title       | body                 | userId |
    | Java        | Learning Java        | 1      |
    | Selenium    | Learning Selenium    | 2      |
    | RestAssured | Learning API Testing | 3      |

  When I execute "POST" request to "/posts/add"
  Then the response status code should be 201