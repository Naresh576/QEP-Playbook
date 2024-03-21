Feature: Login Functionality
  Background: QEP application
    Given     Launch the QEP application as "https://qep-testing.qualizeal.com/landing-page"
    And       Click on login in QEP page
  @Test7
  Scenario Outline: Login to Application
    When            user enter "<username1>" and "<password1>"
    And             Click on Log in button
    Given           User able to click on project repository
    When            User able to select any one project
    Then            User able to click on download button

    Examples:
      | username1 | password1|
      |chotu123@yopmail.com|Chotu786@|
