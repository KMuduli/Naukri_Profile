@SmokeTest
Feature: feature to test Naukari Profile login and logout functionality

  Scenario Outline: Login test with valid credential
    Given user is on login page
    When user enters username "<UserName>" and password "<Password>"
    And click on login button
    Then user is navigated to the home page
    And user click on logout button
    Then User should logout

    Examples: 
      | UserName               | Password   |
      | muduli.k0177@gmail.com | Kanha@2005 |
