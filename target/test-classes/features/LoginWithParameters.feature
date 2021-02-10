Feature: Login as different users

  Scenario: login as a driver user
    Given the user is on the login page
    When user logs in using "User12" and "UserUser123"
    Then the user should be able to login
     And the title contains "Dashboard"

