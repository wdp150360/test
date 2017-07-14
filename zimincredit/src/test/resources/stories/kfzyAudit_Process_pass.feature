Feature: kfzy audit process pass
  贷前主流程（没有评估和实地部门）-客服专员进件（提交审核）

  Background: 
    Given kfzy audit process pass Username kfzy01 as "kfzy01" and Password as "aa1111" and name as "客服专员01"

  Scenario: kfzy audit process
    When click Submit audit button product name as "ZD贷前主流程产品"
    Then check status changed
    Then logout kfzy01 audit process
    Then closed browser audit process
