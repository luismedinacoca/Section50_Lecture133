Feature: Submit data to webdriveruniversity.com using contact us form
  Scenario: Submit valid data via contact us form
    Given I access "http://webdriveruniversity.com/Contact-Us/contactus.html" contact us form
    When I enter a valid first name
    And I enter a valid last name
      | Woods |  Jackson | Jones | Medina Coca |
    And I enter a valid email address
    And I enter comments
      | example comment one | example comment two |
    And I click on the sumit button
    Then the information should successfully be submitted via the contact us form.