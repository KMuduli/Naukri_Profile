@SmokeTest
Feature: Update User Profile

  Scenario Outline: Update basic details
    Given user is on login page
    When user enters username "<UserName>" and password "<Password>"
    And click on login button
    Then user is navigated to the home page
    Given View_profile option is Displaying
    When user click on View_profile option
    Then user navigate to user profile page
    When user click edit basic details
    Then edit Basic Details window displayed
    When edit Exprience years "<Years>" and months "<Months>" and current Salary "<Salary>" and Notice Period "<Durations>"
    And user click Save button
    Then basic details updated and window closed.

    Examples: 
      | UserName               | Password   | Years | Months | Salary  | Durations |
      | muduli.k0177@gmail.com | Kanha@2005 |     8 |      6 | 2000000 |         3 |

  Scenario Outline: Update User Resume
    Given user is on login page
    When user enters username "<UserName>" and password "<Password>"
    And click on login button
    Then user is navigated to the home page
    Given View_profile option is Displaying
    When User click on Update Resume button
    Then User upload resume

    Examples: 
      | UserName               | Password   |
      | muduli.k0177@gmail.com | Kanha@2005 |
