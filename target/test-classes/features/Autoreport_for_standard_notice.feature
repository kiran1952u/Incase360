Feature: AutoReport for Standard Notice

  Scenario: Schedule standard auto report successfully
    Given Given the admin logs into the Incase360 application for STANDARD auto report

    When the admin schedules a standard auto report for user "vipul" with notice "Mu" and batch "standard_batch_MSI_01"
    And the admin sets the standard auto report schedule time to "2024-09-23T13:45"
    And the admin submits the standard auto report
    Then the standard AutoReport API should be triggered successfully
