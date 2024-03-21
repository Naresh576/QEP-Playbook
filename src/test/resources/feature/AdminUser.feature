
Feature: Login Functionality
  Background: QEP application
    Given     Launch the QEP application as "https://qep-testing.qualizeal.com/landing-page"
    And       Click on login in QEP page
  @Test8
  Scenario Outline: ProjectAdmin
    When            user enter "<username1>" and "<password1>"
    And             Click on Log in button
    Given           user able to click on organization Admin
    When            user able to Enter "BU01" and "Demo" Names
    And             user able to Enter "fmc" and "DammyDes" name
    And             user able to Enter "CPS" and "CPS Des" project name
    When            user able to give Input values "Nani" and "Varma" and "jaddu123@yopmail.com"
    When            user able to Add project in users
    Then            verify the "jaddu123@yopmail.com" mail on Admin page
    Examples:
      | username1 | password1 |
      |chotu123@yopmail.com|Chotu786@|



