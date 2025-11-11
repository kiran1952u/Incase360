Feature: Bulk Upload for Parent Notice Express Type
  As an admin user
  I want to bulk upload parent notices with Express type
  So that I can create multiple notices efficiently

  Scenario: Bulk upload parent notice with Tamil and Kannada template
    Given I am logged in as admin user for bulk upload
    When I navigate to Bulk Upload menu
    And I click on Bulk Upload submenu
    And I click on Select user dropdown for bulk upload
    And I enter user name "kiran" for bulk upload
    And I select the user from dropdown for bulk upload
    And I select template "Tamil_kannnada_parent_2"
    And I select letterhead "kiran_letterhead3"
    And I upload CSV file "Combine_tamil_kannada_csv_Data_proxy.csv"
    And I enter notice name "Tamil_kannda_auto_report_01"
    And I click submit button for bulk upload
    And I confirm the bulk upload submission
    Then Notice creation API should be triggered 5 times
    And PDF creation API should be triggered
    And I navigate back to bulk upload page and refresh
