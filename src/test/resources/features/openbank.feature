Feature: OpenBank Test Cases

  @Country_ES
  @TestCase_XRAY_xxxx
  Scenario: Home Page Link Test
    Given the user is on home page
    When the user rejects the cookies
    Then the user checks the link containers
    And the user checks the navbar buttons

  @Country_ES
  @TestCase_XRAY_xxxx
  Scenario: Charity Page Items Test
    Given the user is on home page
    When the user accepts the cookies
    Then the user clicks on open solidary button
    And the user checks the charity items