Feature: cszg staff allocation
  初审主管分配人员处理进件（贷前主流程-无评估实地）

  Background: 
    Given cszg staff allocation Username cszg01 as "cszg01" and Password as "aa1111" and name as "初审主管01"

  Scenario: cszg staff allocation
    When staff allocation to cszy01 product name as "ZD贷前主流程产品"
    Then cszg01 check status changed
    Then logout cszg01 staff allocation
    Then closed browser cszg01 staff allocation
