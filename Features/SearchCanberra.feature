Feature: Search for Canberra images
  As a user I want to visit google and search for Canberra images

  Scenario: Search for Canberra images
    Given User starts Chrome browser
    And opens URL "https://www.google.com/"
    When I type "Canberra" in search bar
    And I click Google Search button
    Then select Images tab
    And I can see selected Images tab