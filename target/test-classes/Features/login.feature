Feature: Facebook login

  Scenario Outline: Facebook login with phone no and password
    Given Open google chrome
    And Browse facebook.com
    When User entries <phoneno> and <password>
    And Press login button
    Then Facebook homepage will display
    And Click on whats on your maind span
    Then Type a status message
    And Click on post button

    Examples: 
      | phoneno     | password |
      | 01810688491 |   123456 |
