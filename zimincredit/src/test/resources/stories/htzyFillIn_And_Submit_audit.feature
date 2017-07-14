Feature: htzy fill in and submit audit contract
  合同专员处理进件及提交审核

  Background: 
    Given htzy fill in and submit contract Username htzy01 as "htzy01" and Password as "aa1111" and name as "合同专员01"

  Scenario: htzy fill in and submit audit contract
    When htzy click dispose button product name as "ZD贷前主流程产品"
    When htzy click tab contract
    Then htzy click save button in tab contract
    When htzy click tab loan message
    Then htzy fill in loan message
      | Fields  | Values      |
      | 合同编号    |         123 |
      | 客户名     | 李四          |
      | 客户指定收款人 | 万物          |
      | 放款账户    |        1234 |
      | 放款账号    |   1234567 |
      | 部门      | 测试          |
      | 放款金额    |     1000000 |
      | 手机号码    | 1881111111 |
      | 客户银行账号  | 12345678 |
      | 客户开户行   | 建行分行        |
		Then htzy click save button in tab loan message
		When htzy click process submit button
		Then htzy check product status changed
		When htzy click submit audit button
		Then htzy check product status changed after submit
		Then logout htzy fill in and submit contract
    Then closed browser htzy fill in and submit contract