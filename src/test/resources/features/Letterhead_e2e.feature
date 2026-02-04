@Letterhead @E2E
Feature: Letterhead Management - Create and Delete
  As an admin user
  I want to create and delete letterheads
  So that I can manage letterhead templates in the system

  Scenario: Admin creates a letterhead with unique name and then deletes it
    Given the admin is logged into the application
    When the admin navigates to the letterhead management section
    And the admin clicks the Add New button for letterhead
    And the admin enters a unique letterhead name
    And the admin enters header margin as "60"
    And the admin enters footer margin as "20"
    And the admin uploads the letterhead image file
    And the admin uploads the signature image file
    And the admin enters signature width as "100"
    And the admin enters signature height as "50"
    And the admin clicks the Submit button for letterhead creation
    Then the letterhead should be created successfully
    When the admin navigates back to the letterhead management section
    And the admin clicks the delete button for the letterhead
    And the admin confirms the deletion in the dialog
    Then the letterhead should be deleted successfully
