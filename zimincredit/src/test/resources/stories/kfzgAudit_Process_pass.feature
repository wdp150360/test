Feature: kfzg audit process pass
  贷前主流程（没有评估和实地部门）-客服主管进件（提交审核）

  Background: 
    Given kfzg audit process pass Username kfzg01 as "kfzg01" and Password as "aa1111" and name as "客服主管"

  Scenario: kfzg audit process
    When click commit button product name as "ZD贷前主流程产品"
    Then kfzg01 check status changed
    Then logout kfzg01 audit process
    Then closed browser kfzg01 commit process
