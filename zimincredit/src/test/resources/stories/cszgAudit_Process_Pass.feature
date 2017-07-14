Feature: cszg audit process pass
  初审主管通过复核提交（贷前主流程-无评估实地）

  Background: 
    Given cszg audit process pass Username cszg01 as "cszg01" and Password as "aa1111" and name as "初审主管01"

  Scenario: audit process pass
    When cszg click submit audit button product name as "ZD贷前主流程产品"
		Then cszg check product status changed
		Then logout cszg audit process
		Then close browser cszg audit process