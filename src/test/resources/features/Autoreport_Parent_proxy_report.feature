Feature: Autoreport Parent Proxy Report
  As an admin user
  I want to generate auto report for parent proxy
  So that parent notice API and merged script API can be triggered

  Scenario: Generate autoreport for parent proxy with student kiran and teacher Gujra
    Given I am logged in as admin user for parent proxy report
    When I navigate to Autoreport menu
    And I click on Autoreport submenu
    And I click on Select user dropdown
    And I enter user name "kiran"
    And I select the user from dropdown
    And I click on noticetype dropdown
    And I enter noticetype name "Gujra"
    And I select the noticetype from dropdown
    And I click on batch dropdown
    And I select batch from checkbox
    And I click on datetime field
    And I enter datetime "2024-09-23T13:45"
    And I click submit button
    And I confirm the autoreport submission
    Then Parent notice API should be triggered
    And Merged script API should be triggered
    And I navigate back to autoreport page and refresh
