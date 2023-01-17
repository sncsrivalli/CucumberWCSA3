
Feature: Login Feature Actitime
  Scenario Outline: Actitime Login
    Given Open browser and enter actitime url
    When User enters <username> and <password> 
    And hits on login button
    Then Home page with <status> should be displayed

    Examples: 
      | username  | password | status  |
      | admin			|   manager| success |
      | trainee   |  trainee | success |
      | abcde     | abc123  | fail    |
