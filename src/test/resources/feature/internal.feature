Feature: internal
  Background:User can log in
    Given the user is on the Demo Web Shop login page
    When the user enters valid credentials
    And clicks the login button
@Test1
  Scenario: User can log in with Organization Repository
    Given the user is on the Demo Web Shop login page
    When the user enters valid credentials
    And clicks the login button
    And verify user able click on documents
    When user able to click on kebab menu
    Then verify user able to click on download

  @Test2
  Scenario: project repository
    Given user able to click on project repository
    When user able to see project name
    Then verify user able to click on download button
@Test3
  Scenario: Organization Admin
    Given user able to click on org Admin
    When usr able to add Bunit
    And  user able to click on program and Add
    And user able to click on Project and Add
    Then user able to click on users
    When user able to Add project from users
    Then verify user able to validate
  @Test4
  Scenario: Project Admin
    Given user able to click on Project Admin

