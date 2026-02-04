Feature: Complete Batch Upload and Send Flow
  As an admin user
  I want to create a batch and then send it
  So that I can complete the entire notice workflow

  @E2E @BatchFlow
  Scenario: Create batch then send it to borrowers
    # ========================================
    # PART 1: CREATE BATCH (Bulk Upload)
    # ========================================
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

    # ========================================
    # PART 2: SEND BATCH (Bulk Send)
    # ========================================
    When the admin navigates to the bulk send section
    And the admin selects "vipul" as the user from the user picker
    And the admin selects "multiple_coborrower_standard" as the notice type
    And the admin selects the batch that was created earlier from dropdown
    And the admin opens the date picker and selects a date
    And the admin clicks the submit button
    Then the bulk send confirmation popup should be displayed
    And the admin confirms the bulk send operation

    # ========================================
    # PART 3: TRIGGER SCHEDULED NOTICE API
    # ========================================
    Then the sendScheduledNotice API should be triggered
