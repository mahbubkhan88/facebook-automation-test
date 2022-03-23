Feature: Facbook link test

  Scenario: Test of signup link
    Given Open facebook
    And Click signup link
    Then Verify signup page

  Scenario: Test of messanger link
    Given Open facebook
    And Click messanger link
    Then Verify messanger page
