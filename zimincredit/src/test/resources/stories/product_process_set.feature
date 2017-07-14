Feature: jkzy01 process management

  Background: loginsuccess
    Given customer Username jkzy as "jkzy01" and Password as "aa1111" and name as "监控专员01"

  Scenario: product process set
    Given click button go into process_management page
    Then query needs to bind product name as "信用产品20170612163620"
    Then click button BindingTemplate
    And click button Process_Set
    When Set process template
      |Fields|Values|
      |进件模板|test050802|
      |评估模板|pgtest1|
      |初审模板|test2|
      |实地模板|实地模板050802|
      |终审模板|测试权值|
    Then commit and check bind success
    Then user logout
    And closed browser
    
