@navigate
Feature: Navigation Menu

  Scenario: Navigating Fleet -- Vehicles
    Given the user is on the login page
    And the user enters the sales manager information
    When user navigate on Menu and click Vehicles under Fleet
    Then Expected title should be changed to Vehicles
@DataBase
  Scenario: Navigating Marketing-Campaigns
    Given the user is on the login page
    And the user enters the sales manager information
    When user navigate on Menu and click Campaigns under Marketing
    Then Expected title should be changed to Campaigns

  Scenario: Navigating Activities--Calendar Events
    Given the user is on the login page
    And the user enters the sales manager information
    When user navigate on Menu and click Calendar Events under Activities
    Then Expected title should be changed to Calendars