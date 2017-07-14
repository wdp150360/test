Feature: zszy fill in and submit audit
  终审专员填写进件及提交审核（贷前主流程-无评估实地）

  Background: 
    Given zszy fill in and submit audit Username zszy01 as "zszy01" and Password as "aa1111" and name as "终审专员01"

  Scenario: fill in and submit audit
    When zszy click fill in button product name as "ZD贷前主流程产品"
    Then zszy fill in product field
      | Fields | Values |
      | 审批结果   | 通过     |
      | 复核结果   | 通过     |
      | 审批理由   | 审批通过   |
    Then zszy click fill in submit button
    Then zszy fill in check product status changed
    When zszy click submit audit button
    Then zszy staff allocation to zsfh01
    Then zszy staff allocation check product status changed
    Then logout zszy01 fill in and submit audit
    Then closed browser zszy01 fill in and submit audit
