Feature: zsfh audit process pass
  终审复核通过复核提交（贷前主流程-无评估实地）

  Background: 
    Given zsfh audit process pass Username zsfh01 as "zsfh01" and Password as "aa1111" and name as "终审复核01"

  Scenario: audit process pass
    When zsfh click submit audit button product name as "ZD贷前主流程产品"
		Then zsfh check product status changed
		Then logout zsfh audit process
		Then close browser zsfh audit process