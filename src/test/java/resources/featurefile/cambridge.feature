Feature: Cambridge course test
  As a user, I want to search for course

  @smoke
 Scenario Outline: User should able to register to apply for course
  Given User is on course page
  When I click on apply now button
  And I click on register button from login page
  And I enter firstname "<first name>"
  And I select day "<day>" month "<month>" year "<year>"
  Then I click on register button

  Examples:
         |first name | day |month |year|
         |Smith      |1    |January     |2001|

  @smoke
  Scenario Outline: User should able to search course
    Given User is on course page
    When I enter course computer "<course>"
    And I click on search button
    Then I should able to see result based on search

    Examples:
      |  course   |
      |  computer |









