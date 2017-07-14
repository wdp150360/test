Feature: User login in to zmcredit page

  Scenario: kfzy01 login in
    Given user open brower "https://120.55.94.106:808/dist/index.html"
    Given maximize the page
    Given user input username "kfzy01"
    Given user input password "aa1111"
    When user click the button login
    Then user login in the zmcredit system as "客服专员"