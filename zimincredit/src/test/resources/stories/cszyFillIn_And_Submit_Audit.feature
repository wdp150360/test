Feature: cszy fill in and submit audit
  初审专员填写进件及提交审核（贷前主流程-无评估实地）

  Background: 
    Given cszy fill in and submit audit Username cszy01 as "cszy01" and Password as "aa1111" and name as "初审专员01"

  Scenario: fill in and submit audit
    When click fill in button product name as "ZD贷前主流程产品"
    Then cszy fill in product field
      | Fields | Values |
      | 审批结果   | 通过     |
      | 审批理由   | 审批通过   |
    Then click fill in submit button
    Then cszy fill in check product status changed
    When cszy click submit audit button
    Then cszy staff allocation to csfh01
    Then cszy staff allocation check product status changed
    Then logout cszy01 fill in and submit audit
    Then closed browser cszy01 fill in and submit audit
