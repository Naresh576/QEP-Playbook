
Feature: Login Functionality
  Background: QEP application
    Given     Launch the QEP application as "https://qep-testing.qualizeal.com/landing-page"
    And       Click on login in QEP page
  @Test9
  Scenario Outline: Login to Application
    When            user enter "<username1>" and "<password1>"
    And             Click on Log in button
    Given user able to click on project Admin "Ravi" and "Jaddu" and "ravijaddu4311@yopmail.com" and "ValueLabs"

    Examples:
      | username1 | password1|
      |chotu123@yopmail.com|Chotu786@|




