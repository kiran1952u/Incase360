@LetterheadCreation
Feature: Letterhead Creation

  As an admin
  I want to create a new letterhead with custom formatting
  So that notices can be generated with branded letterhead

  Background:
    Given the admin is logged into the application for letterhead creation

  @CreateLetterhead @Smoke
  Scenario: Successfully create a new letterhead with images and formatting
    When the admin navigates to the letterhead management section for creation
    And the admin clicks the Add New button for letterhead creation
    And the admin enters a unique letterhead name for creation
    And the admin enters header margin as "50" for letterhead
    And the admin enters footer margin as "40" for letterhead
    And the admin uploads the letterhead image file for creation
    And the admin uploads the signature image file for creation
    And the admin enters signature width as "150" for letterhead
    And the admin enters signature height as "50" for letterhead
    And the admin clicks the Submit button for new letterhead creation
    Then the new letterhead should be created successfully
