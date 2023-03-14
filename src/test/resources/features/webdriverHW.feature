@webdriverHW
Feature: Webdriver functions
  @webdriverHW1
  Scenario: Opening webpage
    Given I will open webpage url
  @webdriverHW2
  Scenario: If...else condition
    Given I open "udemy"
    And I print out url and title
  @webdriverHW3
  Scenario: for loop and for Each
    Given I will open "https://cdc.gov/" then then "https://www.who.int/" then "https://www.nih.gov/"
  @webdriverHW4
  Scenario: Submitting required fields in Quote
    Given I  will open "Submit Quote" page
    When I fill all the required fields
    And I will submit the Quote form
  @webdriverHW5
  Scenario: Submit inputs to all fields in Quote
    Given I will provide inputs to all the elements
  @webdriverHW6
  Scenario: Verify that submitted form is correct
    Given I verify the Quote form
