@webdriver
  Feature: Webdriver methods
    @webdriver1
    Scenario: Open a page
      Given I open any url
    @webdriver2
    Scenario: If else
      Given I go to "google"
      And I print details
    @webdriver3
    Scenario: Loop
      Given I open "https://www.google.com" then then "https://yahoo.com" then "https://www.bing.com"
    @webdriver4
    Scenario: Element steps
      Given I open "quote" page
      When I fill out first name "Rea" and last name "Tabofunda"
      And I fill out required fields
      And I fill out contact name "John Smith" and contact phone "408-0000-123" in additional information
      Then I assert required fields

