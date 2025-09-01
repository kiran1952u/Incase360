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



Feature: Auto Download Without Tracking

  Scenario: Admin schedules auto download without tracking
    Given I login as admin
    When I navigate to Auto Download Without Tracking module
    And I fill in the Auto Download form
    Then I submit the Auto Download request

