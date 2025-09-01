Feature: Auto Download With Tracking (Express Notice)

  Scenario: Schedule multiple batches and trigger Auto Download API
    Given the admin logs into the Incase360 application
    When schedules auto download for the following batches:
      | vipul | Express_make_op | Express_pdf_Creation_01 |
      | vipul | Express_make_op | Make_op_pdf_01          |
      | vipul | Express_make_op | Test_01_02              |
      | vipul | Express_make_op | test_rejected_notice_pro|
      | vipul | Express_make_op | PDF_gen_01              |
    And the AutoDownload API is triggered 5 times
    Then the response should be successful each time
