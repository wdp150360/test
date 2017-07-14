Feature: User login in to zmcredit page

  Scenario: kfzy01 login in and log an issue
    Given user open brower "https://120.55.94.106:808/dist/index.html"
    Given maximize the page
    Given user input username "kfzy01"
    Given user input password "aa1111"
    When user click the button login
    Then user login in the zmcredit system as "客服专员01"

    Given customer coordinator click button record issue
    Given customer coordinator select loan type "信用贷款" ,"信用" and product "testA0525 - 1"
    Given customer coordinator click new customer issue
    When customer coordinator click submit
    When customer coordinator click alert yes
    When customer coordinator click alert sure
    Then customer coordinator a new loan issue was added to the loan issue list
    Then customer coordinator new loan issue's loan product is "testA0525"
    Then customer coordinator new loan issue's status is "待提交"
    Then customer coordinator new loan issue's process is "客服专员01"
    Then customer coordinator new loan issue's operation is
      | 提交审核 |
      | 评估  |
      | 填写 |


