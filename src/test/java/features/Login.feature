Feature: Here we will automate Login application of Saucelab webpage.

  Background: Enter the URL https://www.saucedemo.com
    Given: The user is on login page


  Scenario Outline: Validating positive scenario
    When User enters username "<username>" and password "<password>"
    And User clicks on Login button
    Then User enters the products webpage

    Examples: 
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |

  Scenario Outline: Validating negative scenario
    When User enters username "<username>" and password "<password>"
    And User clicks on Login button
    Then User finds an error message "Epic sadface: Username and password do not match any user in this service"

    Examples: 
      | username | password |
      | user1    | abc@123  |
      | user2    | xyz@123  |
