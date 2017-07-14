Feature: zszg audit process pass
  终审主管通过复核提交（贷前主流程-无评估实地）

  Background: 
    Given zszg audit process pass Username zszg01 as "zszg01" and Password as "aa1111" and name as "终审主管01"

  Scenario: audit process pass
    When zszg click submit audit button product name as "ZD贷前主流程产品"
		Then zszg check product status changed
		Then logout zszg audit process
		Then close browser zszg audit process