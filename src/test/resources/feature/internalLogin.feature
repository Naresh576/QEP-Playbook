@Smoke1
Feature: Login Functionality
  Background: QEP application
    Given     Launch the QEP application as "https://qep-testing.qualizeal.com/landing-page"
    And       Click on login in QEP page

  @Smoke3
  Scenario Outline: Login to Application
    When            user enter "<username1>" and "<password1>"
    And             Click on Log in button
    Then            Validate "Recently Uploaded Documents" text on the page


    Examples:
      | username1 | password1|
      |chotu123@yopmail.com|Chotu786@|

  Scenario Outline: Login Page error
    When            user enter "<username1>" and "<password1>"
    And             Click on Log in button
    Then            Verify the error message

    Examples:
      | username1 | password1|
      |chotu123@yopmail.co|Chotu786@|


  Scenario Outline: Login Page email and password error
    When            user enter "<username1>" and "<password1>"
    And             Click on Log in button
    Then            Verify the error message on email input field
    And             Verify the error message on password input field

    Examples:
      | username1 | password1|
      |||



#  Scenario: Login to QEP application with valid credentials
#    When User enter valid username and valid password
#    Then Click on Log in button
#    And Verify the Organization name
#
