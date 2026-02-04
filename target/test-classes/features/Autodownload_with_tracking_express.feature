Feature: Auto Download Without Tracking
  This feature tests the scheduling and triggering of an auto-download job without tracking,
  after logging into the admin panel.

  Background:
    Given the admin is logged into the system

  Scenario: Schedule and trigger an autodownload without tracking
    When the admin navigates to the autodownload page
    And selects user "vipul"
    And selects template "multiple_coborrower_standard"
    And selects batch "large_batch"
    And sets the current date and time for scheduling
    And submits the autodownload form
    Then the autodownload API should be triggered successfully
