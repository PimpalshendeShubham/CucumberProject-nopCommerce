Feature: Search Customer

@smoke 
  Scenario: Search Customer by Email
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers Dropdown Menu
    And click on customers Item
    And Enter customer Email
    When Click on search button
    Then User should found Email in the Search table
    And close browser

@Sanity @Regression
  Scenario: Search Customer by Name
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers Dropdown Menu
    And click on customers Item
    And Enter customer Name
    When Click on search button
    Then User should found Name in the Search table
    And close browser
