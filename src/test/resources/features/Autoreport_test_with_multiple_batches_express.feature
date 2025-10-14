Feature: Auto Report for Multiple Batches Express

  Background:
    Given I am logged in as an admin
    And I navigate to the autoreport page

  Scenario Outline: Generate autoreport for multiple batches
    When I fill student as "vipul"
    And I select teacher as "Com"
    And I select batch "<batchName>"
    And I set datetime as "2024-09-23T13:45"
    And I pick a random class
    And I submit the autoreport
    Then The parent notice API should be triggered

    Examples:
      | batchName               |
      | Test_que_table_entry_01 |
      | without_com_express_01  |
      | without_com_express_02  |

