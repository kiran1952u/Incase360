Feature: Bulk Send for Standard Notice
  As an admin user
  I want to bulk send standard type notices
  So that I can efficiently dispatch notices to multiple borrowers

  @BulkSend @Standard
  Scenario: Admin performs bulk send operation for standard notice type
    Given the admin user is logged into the Incase360 application
    When the admin navigates to the bulk send section
    And the admin selects "vipul" as the user from the user picker
    And the admin selects "multiple_coborrower_standard" as the notice type
    And the admin selects the batch that was created earlier from dropdown
    And the admin opens the date picker and selects a date
    And the admin clicks the submit button
    Then the bulk send confirmation popup should be displayed
    And the admin confirms the bulk send operation
