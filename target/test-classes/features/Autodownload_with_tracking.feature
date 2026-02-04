#Feature: Auto Download Without Tracking
#
#  Scenario: Perform auto download without tracking
#    Given I login as admin
#    When I navigate to auto download without tracking
#    And I select enterprise "vipul"
#    And I select notice type "multiple_coborrower_standard"
#    And I enter batch name "Test_auto_downlaod"
#    And I set current date and time
#    And I submit the form
#    Then Auto download API should be called

#Feature: Auto Download Without Tracking
#
#  Scenario: Admin schedules auto download without tracking
#     Given I login as admin
#    When I navigate to Auto Download Without Tracking module
#    And I fill in the Auto Download form
#    Then I submit the Auto Download request


Feature: Auto Download With Tracking (Express Version)

  As an admin user
  I want to log in and schedule an auto download with tracking
  So that I can verify that the auto download functionality works correctly

  @AutoDownloadWithTrackingExpress
  Scenario: Verify that admin can create an auto download successfully
    Given the admin is logged into the system
    When the admin navigates to the autodownload page
    And selects user "vipul"
    And selects template "multiple_coborrower_standard"
    And selects batch "large_batch"
    And sets the current date and time for scheduling
    And submits the autodownload form
    Then the autodownload API should be triggered successfully


