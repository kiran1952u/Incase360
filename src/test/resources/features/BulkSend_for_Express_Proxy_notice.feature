Feature: Bulk Send for Express Proxy Notice
  As an admin user
  I want to bulk send express proxy notices
  So that I can efficiently manage multiple notice dispatches

  @BulkSend @Express @Proxy
  Scenario: Admin performs bulk send for express proxy notices
    Given the admin user is logged into the application
    When the admin navigates to the bulk send section
    And the admin selects "kiran" as the user
    And the admin selects "Tamil_kannnada_parent_2" as the notice type
    And the admin selects a date from the date picker
    And the admin clicks the submit button
    Then the bulk send confirmation should be displayed
    And the admin confirms the bulk send operation

#  Future Enhancement: Bulk send with sequential notice IDs
#  Scenario: Admin sends multiple notices with sequential IDs
#    Given the admin user is logged into the application
#    When the admin navigates to the bulk send section
#    And the admin enters notice ID range from "IN3155-1" to "IN3155-10"
#    Then all notices should be sent successfully
