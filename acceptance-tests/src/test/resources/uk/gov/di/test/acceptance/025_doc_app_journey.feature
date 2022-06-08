Feature: Doc App Journey
  Doc App client authenticates

  Scenario: Doc App client authenticates
    Given the authentication services are running
    And the doc app user clears cookies
    When the doc app user visits the doc app stub relying party
    And the doc app user clicks continue
    Then the doc app user is taken to the doc app cri stub
