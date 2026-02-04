Feature: Bulk Upload for Parent Notice Standard Type
  As an Admin user
  I want to upload parent notice with standard type
  So that I can process bulk notices efficiently

  @BulkUploadStandard
  Scenario: Upload parent notice with standard type batch from CSV
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
