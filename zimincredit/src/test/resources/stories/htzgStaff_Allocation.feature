Feature: htzg staff allocation
  合同主管分配专员处理进件

  Background: 
    Given htzg staff allocation Username htzg01 as "htzg01" and Password as "aa1111" and name as "合同主管01"

  Scenario: htzg staff allocation
    When staff allocation to htzg01 product name as "ZD贷前主流程产品"
    Then htzg01 check status changed
    Then logout htzg01 staff allocation
    Then closed browser htzg01 staff allocation