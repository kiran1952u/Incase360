Feature: Bulk Upload for Parent Notice Express Type
  As an admin user
  I want to bulk upload parent notices with Express type
  So that I can create multiple notices efficiently

  @BulkUploadExpress
  Scenario: Bulk upload parent notice with Tamil and Kannada template
    Given I am logged in as admin user for bulk upload
    When I navigate to Bulk Upload menu
    And I click on Bulk Upload submenu
    And I click on Select user dropdown for bulk upload
    And I enter user name "vipul" for bulk upload
    And I select the user from dropdown for bulk upload
    And I select template "Proxy_kiran_01_3542_3543"
    And I select letterhead "vipul_letterhead"
    And I upload CSV file "3542_3543.csv"
    And I enter notice name "proxy_vipul_test_01"
    And I click submit button for bulk upload
    And I confirm the bulk upload submission
    Then Notice creation API should be triggered 5 times
    And PDF creation API should be triggered
    And I navigate back to bulk upload page and refresh
