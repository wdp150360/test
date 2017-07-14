Feature: zszg staff allocation
  终审主管分配人员处理进件（贷前主流程-无评估实地）

  Background: 
    Given zszg staff allocation Username zszg01 as "zszg01" and Password as "aa1111" and name as "终审主管01"

  Scenario: zszg staff allocation
    When staff allocation to zszy01 product name as "ZD贷前主流程产品"
    Then zszg01 check status changed
    Then logout zszg01 staff allocation
    Then closed browser zszg01 staff allocation