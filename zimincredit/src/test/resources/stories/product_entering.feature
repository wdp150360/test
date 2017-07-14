Feature: kfzy01 product entering
  进件录入kfzy01

  Background: loginsuccess
    Given customer Username kfzy01 as "kfzy01" and Password as "aa1111" and name as "客服专员01"

  Scenario: product entering
    Then click button product entering
    Then select  productType as "信用贷款" and subProductType as "信用" and productName as "信用产品20170612163620 - 1.0"
    When click new customer entering button
    Then fill in product entering
      | Fields | Values |
      | 曾用名    | assss  |
      | 审批结果   | 通过     |
      | 复核结果   | 通过     |
      | 最终复核结果 | 通过     |
    When click product entering commit button
    Then check product entering commit success productName as "信用产品20170612163620"
    Then logout kfzy01 product entering
    Then closed browser product entering
