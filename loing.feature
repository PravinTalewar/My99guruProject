Feature: login feature

  Scenario: 1.user is able to login in the application
    Given user operated the browser
    And user click Resister page
    Then user fill Resister form


  Scenario: 2.user automated sing in flow
    Given user operated browser
    And user enter user name and password
    Then user click submit button


  Scenario: 3 Automate flight
    Given user automated the browser
    And user click flight option
    Then user enter flight detail
    And  user click continue button

