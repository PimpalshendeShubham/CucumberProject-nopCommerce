Feature: Login

  @Smoke @Sanity
  Scenario: Successful Login with Valid Credentials
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User click on Log out link
    Then Page Title should be "Your store. Login"
    And close browser

  @Sanity @Regression
  Scenario Outline: Unsuccessful Login With Invalid Credentials
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Your store. Login"
    And close browser

    Examples: 
      | email        | password |
      | test@123.com | test123  |
      | test@456.com | test456  |
      | test@789.com | test789  |

  @smoke @Sanity
  Scenario: Unsuccessful login with Invalid credentials
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as email and Password as password
      | email        | password |
      | test@321.com | test321  |
      | test@654.com | test654  |
      | test@987.com | test987  |
    And Click on Login
    Then Page Title should be "Your store. Login"
    And close browser
