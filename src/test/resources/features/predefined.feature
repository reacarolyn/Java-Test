@predefined
Feature: Smoke steps

  @predefined1
  Scenario: Predefined steps for Google
    Given I open url "https://google.com"
    Then I should see page title as "Google"
    Then element with xpath "//input[@name='q']" should be present
    When I type "Behavior Driven Development" into element with xpath "//input[@name='q']"
    Then I click on element using JavaScript with xpath "(//input[@name='btnK'])[1]"
    Then I wait for element with xpath "//*[@id='res']" to be present
    Then element with xpath "//*[@id='res']" should contain text "Cucumber"

 @predefined2
 Scenario: Predefined steps for Yahoo
    Given I open url "https://www.yahoo.com/"
    Then I should see page title as "Yahoo | Mail, Weather, Search, Politics, News, Finance, Sports & Videos"
    When I type "cheese" into element with xpath "//input[@id='ybar-sbq']"
    And I click on element with xpath "//input[@id='ybar-search']"
    And I wait for 2 sec
    Then element with xpath "//div[@id='results']" should contain text "cheese"

  @predefined3
  Scenario: Predefined steps for Yandex
    Given I open url "https://yandex.com/"
    Then I should see page title as "Yandex"
    When I type "automation" into element with xpath "//*[@id='text']"
    And I click on element with xpath "//button[@type='submit']"
    And I wait for 2 sec
    Then element with xpath "//div[@class='main__content']" should contain text "automation"

  @predefined4
  Scenario: Predefined steps for Bing
   Given I open url "https://www.bing.com/"
   Then I should see page title as "Bing"
   When I type "automation" into element with xpath "//input[@id='sb_form_q']"
   And I click on element with xpath "//label[@id='search_icon']"
   And I wait for 2 sec
   Then element with xpath "//div[@id='b_content']" should contain text "automation"
