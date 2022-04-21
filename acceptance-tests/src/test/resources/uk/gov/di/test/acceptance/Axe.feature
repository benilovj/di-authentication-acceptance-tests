@Axe
Feature: Axe scan
  A user runs an accessibility scan


  Scenario: Running accessibility test
    Given a user navigates to the build account page
    When a user runs accessibility tests
    Then the user gets results