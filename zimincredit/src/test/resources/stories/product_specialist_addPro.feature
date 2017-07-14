Feature: Product specialist new product
  产品专员新增产品

  Background: loginsuccess
    Given customer Username cpzy as "cpzy01" and Password as "aa1111" and name as "产品专员01"

  Scenario: user cpzy01 add product
    Given click add product
    And fill in content of pruduct
    When click commit button
    Then add product success and check to see if the product list is new

