Feature: As an Admin User of the Nop Commerce
  		I want to add a customer data into the Application 
  		so that I can create the Record in the Customer List

  @Smoke @Sanity @Regression
  Scenario: Add New Customer
    Given User Launch Chrome browser
    When User opens URL "http://admin-demo.nopcommerce.com/login"
    And User enters Email as "admin@yourstore.com" and Password as "admin"
    And Click on Login
    Then User can view Dashboard
    When User click on customers Dropdown Menu
    And click on customers Item
    And click on Add new button
    Then User can view Add new customer page
    When User enter customer info
      | password    | test@123     |
      | firstName   | Shubham      |
      | lastName    | Pimpalshende |
      | Gender      | Male         |
      | DOB         | 12/2/1998    |
      | companyName | SVP pvt Ltd  |
    And click on Save button
    Then User can view confirmation message "The new customer has been added successfully."
    And close browser
