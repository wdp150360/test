Feature: csfh audit process pass
  初审复核通过复核提交（贷前主流程-无评估实地）

  Background: 
    Given csfh audit process pass Username cszy01 as "csfh01" and Password as "aa1111" and name as "初审复核01"

  Scenario: audit process pass
    When csfh click submit audit button product name as "ZD贷前主流程产品"
		Then csfh check product status changed
		Then logout csfh audit process
		Then close browser csfh audit process