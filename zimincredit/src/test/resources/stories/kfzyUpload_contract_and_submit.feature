Feature: kfzy upload contract and submit
  客服专员上传合同并提交

  Background: 
    Given kfzy upload contract and submit as "kfzy01" and Password as "aa1111" and name as "客服专员01"

  Scenario: upload contract and submit
    When kfzy click upload contract button product name as "ZD贷前主流程产品"
    Then kfzy click upload contract button and upload pic
    When kfzy click closed contract page button
    Then kfzy upload contract check product status changed
		When kfzy click submit button to htzg
		Then kfzy submit to htzg check product status changed
		Then logout kfzy upload contract and submit
    Then closed browser kfzy upload contract and submit