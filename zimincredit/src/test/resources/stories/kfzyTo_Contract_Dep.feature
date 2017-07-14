Feature: kfzy to contract department
  客服专员提交进件到合同部门

  Background: 
    Given kfzy to contract department Username kfzy01 as "kfzy01" and Password as "aa1111" and name as "客服专员01"

  Scenario: kfzy to contract department
    When kfzy click submit button product name as "ZD贷前主流程产品"
    Then kfzy check product status changed
    Then logout kfzy to contract dep
    Then closed browser kfzy to contract dep