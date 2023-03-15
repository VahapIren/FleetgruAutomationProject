@FLEET10-689
Feature: Login Functions

  Background:
    Given User is on the Fleetgru login page

  @FLEET10-578
  Scenario: Login as a truck driver
    When User log in as a truck driver
    Then User should be on the "Quick Launchpad" page

  @FLEET10-579
  Scenario: Login as a sales manager
    When User log in as a sales manager
    Then User should be on "Dashboard" page

  @FLEET10-580
  Scenario: Login as a store manager
    When User log in as a store manager
    Then User should be on "Dashboard" page

  @FLEET10-604
  Scenario: Login with invalid password
    When user logins with valid "username" and "invalid_password"
    Then user should see "Invalid user name or password."

  @FLEET10-605
  Scenario: Login with invalid username
    When user logins with "invalid_username" and valid "password"
    Then user should see "Invalid user name or password."

  @FLEET10-607
  Scenario: Login without any username but with password
    When user logins without any username
    Then user should see Please fill out this field on username field

  @FLEET10-608
  Scenario: Login without any password but with username
    When user logins without any password
    Then user should see Please fill out this field on password field

  @FLEET10-609
  Scenario: Login without any username and password
    When user logins without any username and password
    Then user should see Please fill out this field on username field

    Scenario Outline: Login Button Functionality
      When user send "<username>" and "<password>"
      Then user see "<message>"
      Examples:
        | username | password | message |
        |          | anything | message |
        | anything |          | message |
        |          |          | message |

  @FLEET10-629
  Scenario: Land on 'Forgot Password' page after clicking 'Forgot your password?' link
    When User click on the 'Forgot your password?' link
    Then User should land on the 'Forgot Password' page

  @FLEET10-631
  Scenario: 'Remember Me' link exists and is clickable on the login page
    When User can see 'Remember me' link
    Then The link is clickable

  @FLEET10-636
  Scenario: The password in bullet signs by default
    When User write anything on password input
    Then User should see characters in bullet sign

  @FLEET10-641
  Scenario: 'Enter' key with username but without password
    When user enter username but without password and press Enter
    Then user should see required message on password field

  Scenario: 'Enter' key without any username but with password
    When user enter password but without any username and press Enter
    Then user should see required message on username field

  Scenario: 'Enter' key without any username and password
    When user does not enter username and password and press Enter
    Then user should see required message on username field

  Scenario: 'Enter' key with valid username and password
    When user enter valid username and password and press Enter
    Then user should land to Dashboard page

  Scenario: 'Enter' key with invalid username or password
    When user enter invalid username or password and press Enter
    Then user should see "Invalid user name or password." message

  Scenario Outline: Enter Button Functionality
    When user logins "<username>" and "<password>" press Enter
    Then user see "<message>"
    Examples:
      | username | password    | message   |  |
      |          | anything    | message   |  |
      | anything |             | message   |  |
      |          |             | message   |  |
      | anything | anything    | message2  |  |
      | user1    | UserUser123 | Dashboard |  |

  @FLEET10-639
  Scenario Outline: User should see own username in the profile menu, after successful login
    When User login as a "<userName>"
    Then "<UserName>" is on the profile menu

    Examples:
      | userName      | UserName        |
      | Driver        | user1           |
      | Sales_Manager | salesmanager101 |
      | Store_Manager | storemanager51  |

  @FLEET10-585
  Scenario Outline: Login as a <userType>
    When User login as a "<userType>"
    Then User is on the "<pageSubTitle>" page
    Examples:
      | userType      | pageSubTitle    |  |
      | Driver        | Quick Launchpad |  |
      | Sales_Manager | Dashboard       |  |
      | Store_Manager | Dashboard       |  |

