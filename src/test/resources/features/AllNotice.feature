Feature: All Notice Management
  As an admin user
  I want to search and manage notices
  So that I can view notice details and parent notices

  Scenario: Search Font notice and Parent notice
    Given I am logged in as admin user
    When I navigate to All Notices menu
    And I click on All Notices submenu
    And I wait for All Notices page to load
    And I search for notice with name "Font_001"
    And I click search button for notices
    And I click on the notice result from table
    And I click download button on notice details
    And I switch to main window
    And I confirm the alert action
    And I click on link button in notice details
    And I click on parent notices tab
    And I click on Proxy Notices menu
    And I search for parent notice with name "Parent_July1"
    And I click search button for parent notices
    And I click on parent notice result
    Then I navigate back to notices list
