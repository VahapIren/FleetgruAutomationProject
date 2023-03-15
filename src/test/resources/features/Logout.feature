@FLEET10-766
  Feature: Logout Functions


    Background:
      Given User already login to the Dashboard page

    @FLEET10-738
      Scenario: Logout with logout button inside profile menu
        When user clicks to the profile menu and see logout button
        And user clicks to the logout button
        Then user should land on the "Login" page

    @FLEET10-740
    Scenario: After logout click Back button
        When user clicks to the profile menu and see logout button
        And user clicks to the logout button
        And user clicks to the Back button
        Then user should land on the "Login" page

        @FLEET10-741
      Scenario: After close open tab/tabs user should be logged out
        When user closes to the tab-tabs
        And user navigate to the login page
        Then user should land on the "Login" page

          @FLEET10-742
      Scenario: After away from the keyboard for 3 minutes user should be logged out
        When user wait 3 minutes
        Then user should land on the "Login" page
