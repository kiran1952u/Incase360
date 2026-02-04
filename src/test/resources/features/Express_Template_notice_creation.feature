Feature: Express Template Notice Creation
  As an admin user
  I want to create express notice templates
  So that I can use them for sending notices to borrowers

  Background:
    Given the admin user is logged into the application

  @TemplateCreation @Express
  Scenario Outline: Create express notice template with different names and then delete it
    When the admin navigates to the create template page
    And the admin enters notice type "<noticeType>" with unique ID
    And the admin enters notice description "<noticeDescription>" with unique ID
    And the admin selects the express template option
    And the admin clicks the proceed button
    And the admin enters data field "KIRAN"
    And the admin enters the express notice template text
    And the admin uploads the CSV file "src/test/resources/testdata/format.csv"
    And the admin scrolls to the submit button
    And the admin clicks the submit button for template creation
    Then the template should be created successfully
    When the admin navigates to the templates list page
    And the admin searches for the created template
    And the admin clicks the delete button for the template
    And the admin confirms the template deletion
    Then the template should be deleted successfully

    Examples:
      | noticeType           | noticeDescription              |
      | Dummy_express_notice | Dummy_express_description      |
      | Test_notice          | Test_description               |
