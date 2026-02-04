Feature: Complete E2E Batch Flow - Upload, Bulk Send, Auto Report and Auto Download

  @CompleteE2EFlow
  Scenario: Complete workflow - Upload batch, send via bulk send, schedule auto report and auto download

    # ========== STEP 1: BATCH UPLOAD ==========
    Given Admin logs into the application
    When Admin navigates to bulk upload section
    And Admin searches for user "vipul"
    And Admin selects option 28 from first dropdown
    And Admin selects option 2 from second dropdown
    And Admin uploads CSV file "Batch_04.csv"
    And Admin enters batch name with prefix "standard_batch_MSI_"
    And Admin clicks submit button
    And Admin confirms the upload
    And System triggers parent API for PDF generation
    Then Page should be refreshed successfully

    # ========== STEP 2: BULK SEND ==========
    When the admin navigates to the bulk send section
    And the admin selects "vipul" as the user from the user picker
    And the admin selects "multiple_coborrower_standard" as the notice type
    And the admin selects the batch that was created earlier from dropdown
    And the admin opens the date picker and selects a date
    And the admin clicks the submit button
    Then the bulk send confirmation popup should be displayed
    And the admin confirms the bulk send operation
    Then the sendScheduledNotice API should be triggered

    # ========== STEP 3: AUTO REPORT ==========
    When the admin schedules auto report for user "vipul" with notice "multiple_coborrower_standard" using newly created batch
    And the admin sets the auto report schedule time to "2024-09-23T13:45" for E2E flow
    And the admin submits the auto report for E2E flow
    Then the AutoReport API should be triggered successfully for E2E flow

    # ========== STEP 4: AUTO DOWNLOAD ==========
    When I navigate to Auto Download module for E2E flow
    And I fill in the Auto Download form with user "vipul" and notice "multiple_coborrower_standard" using newly created batch
    Then I submit the Auto Download request for E2E flow
