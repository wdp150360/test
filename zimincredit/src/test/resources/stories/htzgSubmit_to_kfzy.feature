Feature: htzg submit to kfzy
  合同主管提交进件到客服专员上传合同

  Background: 
    Given htzg submit to kfzy Username htzg01 as "htzg01" and Password as "aa1111" and name as "合同主管01"

  Scenario: htzg submit to kfzy
    When htzg click submit button product name as "ZD贷前主流程产品"
    Then htzg submit to kfzy check product status changed
    Then logout htzg submit to kfzy
    Then closed browser htzg submit to kfzy