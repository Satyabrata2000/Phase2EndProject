Feature: Here we will validate product prices

  Background: Open Swag Labs application
    Given User is on login page
    When User enters Username "standard_user" and Password "secret_sauce"
    And User clicks on Login button

  Scenario: To validate Product Prices
    When User is on Products Page
    Then User compares the following products price
      | Sauce Labs Backpack   | $29.99 |
      | Sauce Labs Bike Light |  $9.99 |