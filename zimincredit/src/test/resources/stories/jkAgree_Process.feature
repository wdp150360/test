Feature: jk agree process
  监控部门同意进件审核

  Background: 
    Given jk audit process pass Username jkzy01 as "jkzy01" and Password as "aa1111" and name as "监控专员01"

  Scenario: jk agree process
    When jk click agree button product name as "ZD贷前主流程产品"
    Then jk check product status changed
    Then logout jk agree process
    Then closed browser jk agree process