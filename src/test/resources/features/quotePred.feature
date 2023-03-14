@quotePred
  Feature: Quote Predefined
    @quotePred1
    Scenario: Responsive Behavior
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      When I resize window to 1024 and 800
      Then element with xpath "//b[@id='location']" should be displayed
      And element with xpath "//b[@id='currentDate']" should be displayed
      And element with xpath "//b[@id='currentTime']" should be displayed
      When I resize window to 985 and 800
      Then element with xpath "//b[@id='location']" should be displayed
      And element with xpath "//b[@id='currentDate']" should be displayed
      And element with xpath "//b[@id='currentTime']" should be displayed
      When I resize window to 500 and 1000
      Then element with xpath "//b[@id='location']" should not be displayed
      And element with xpath "//b[@id='currentDate']" should not be displayed
      And element with xpath "//b[@id='currentTime']" should not be displayed
    @quotePred2
    Scenario: Username length validation
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      When I type "r" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//input[@name='email']"
      Then element with xpath "//label[@id='username-error']" should contain text "2 characters"
      When I clear element with xpath "//input[@name='username']"
      And I type "pe" into element with xpath "//input[@name='username']"
      And I click on element with xpath "//input[@name='email']"
      Then element with xpath "//label[@id='username-error']" should not be displayed
    @quotePred3
    Scenario: Confirm Password disabled & enable validation
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      When I click on element with xpath "//input[@name='confirmPassword']"
      Then element with xpath "//input[@name='confirmPassword']" should be disabled
      Then I click on element with xpath "//input[@name='password']"
      And I type "tester123" into element with xpath "//input[@name='password']"
      Then element with xpath "//input[@name='confirmPassword']" should be enabled
    @quotePred4
    Scenario: Name validation
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//div[@role='dialog']" should be displayed
      Then I type "Rea" into element with xpath "//input[@id='firstName']"
      And I type "Tabofunda" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[text()='Save']"
      Then element with xpath "//input[@id='name']" should have attribute "value" as "Rea Tabofunda"
    @quotePred5
    Scenario: Required fields verification
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      When I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//label[@id='username-error']" should contain text "required"
      Then element with xpath "//label[@id='email-error']" should contain text "required"
      Then element with xpath "//label[@id='password-error']" should contain text "required"
      Then element with xpath "//label[@id='name-error']" should contain text "required"
      Then element with xpath "//label[@id='agreedToPrivacyPolicy-error']" should contain text "check"
    @quotePred6
    Scenario: Third Party button, iframe, confirmation
      # Alert pop-up
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      When I click on element with xpath "//button[@id='thirdPartyButton']"
      And I accept alert
      # iframe
      When I switch to iframe with xpath "//iframe[@name='additionalInfo']"
      And I type "John Smith" into element with xpath "//input[@id='contactPersonName']"
      And I type "408-000-0083" into element with xpath "//input[@id='contactPersonPhone']"
      And I switch to default content
      # New window"
      When I click on element with xpath "//*[contains(text(),'Related')]"
      And I switch to new window
      Then element with xpath "//body" should contain text "Document 1"
      And I switch to first window
    @quotePred7
      Scenario: Date of Birth
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      When I click on element with xpath "//input[@id='dateOfBirth']"
      And element with xpath "//div[@id='ui-datepicker-div']" should be displayed
      When I click on element with xpath "//option[@value='3']"
      And I click on element with xpath "//option[@value='2001']"
      And I click on element with xpath "//a[contains(text(),'16')]"
      Then element with xpath "//option[contains(text(),'Apr')]" should be selected
      And element with xpath "//option[contains(text(),'2001')]" should be selected
    @quotePred8
    Scenario: Email format validation
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      #minimum length = 3
      When I type "re" into element with xpath "//input[@name='email']"
      And I click on element with xpath "//input[@name='password']"
      Then element with xpath "//label[@id='email-error']" should contain text "valid email"
      When I clear element with xpath "//input[@name='email']"
      #required field
      And element with xpath "//label[@id='email-error']" should contain text "required"
      #character @ must be present in the middle
      And I type "reatabofundagmail.com" into element with xpath "//input[@name='email']"
      And I click on element with xpath "//input[@name='password']"
      Then element with xpath "//label[@id='email-error']" should contain text "valid email"
    @quotePred9
    Scenario: Password and confirm password
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      #password and confirm password masked
      Then element with xpath "//input[@name='password']" should have attribute "type" as "password"
      Then element with xpath "//input[@name='confirmPassword']" should have attribute "type" as "password"
      #password and confirm password should be required
      Then element with xpath "//input[@name='password']" should have attribute "aria-required" as "true"
      Then element with xpath "//input[@name='confirmPassword']" should have attribute "aria-required" as "true"
      #confirm password disable if password has no value
      When I click on element with xpath "//input[@name='confirmPassword']"
      Then element with xpath "//input[@name='confirmPassword']" should be disabled
      #password length
      When I type "test" into element with xpath "//input[@name='password']"
      Then I click on element with xpath "//label[@class='required'][text()='Password']"
      Then element with xpath "//label[@id='password-error']" should contain text "5 characters."
      # Matching password and confirm password - error
      When I clear element with xpath "//input[@name='password']"
      When I type "tester123" into element with xpath "//input[@name='password']"
      And I type "tester456" into element with xpath "//input[@name='confirmPassword']"
      And I click on element with xpath "//input[@name='username']"
      Then element with xpath "//label[@id='confirmPassword-error']" should contain text "Passwords do not match!"
    @quotePred10
    Scenario: Submit form
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//div[@role='dialog']" should be displayed
      Then I type "Rea" into element with xpath "//input[@id='firstName']"
      And I type "Tabofunda" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[text()='Save']"
      And I type "rtabofunda" into element with xpath "//input[@name='username']"
      And I type "rtabofunda@gmail.com" into element with xpath "//input[@name='email']"
      And I type "test123" into element with xpath "//input[@id='password']"
      And I type "test123" into element with xpath "//input[@id='confirmPassword']"
      And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      Then I click on element with xpath "//button[@id='formSubmit']"
      Then element with xpath "//div[@id='quotePageResult']" should be displayed
      And element with xpath "//b[@name='firstName']" should contain text "Rea"
      And element with xpath "//b[@name='lastName']" should contain text "Tabofunda"
      And element with xpath "//b[@name='password']" should contain text "[entered]"
      And element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
    @quotePred11
    Scenario: Submit form including others non-required field
      Given I open url "https://skryabin.com/market/quote.html"
      Then I should see page title as "Get a Quote"
      #required: name, username, email, password, confirm password
      When I click on element with xpath "//input[@id='name']"
      Then element with xpath "//div[@role='dialog']" should be displayed
      Then I type "Rea" into element with xpath "//input[@id='firstName']"
      And I type "Tabofunda" into element with xpath "//input[@id='lastName']"
      And I click on element with xpath "//span[text()='Save']"
      And I type "rtabofunda" into element with xpath "//input[@name='username']"
      And I type "rtabofunda@gmail.com" into element with xpath "//input[@name='email']"
      And I type "test123" into element with xpath "//input[@id='password']"
      And I type "test123" into element with xpath "//input[@id='confirmPassword']"
      #optional: Phone Number
      And I type "4080000000" into element with xpath "//input[@name='phone']"
      #optional: Date of Birth
      When I click on element with xpath "//input[@id='dateOfBirth']"
      And element with xpath "//div[@id='ui-datepicker-div']" should be displayed
      When I click on element with xpath "//option[@value='3']"
      And I click on element with xpath "//option[@value='2001']"
      And I click on element with xpath "//a[contains(text(),'16')]"
      #Optional:Country of Origin
      When I click on element with xpath "//select[@name='countryOfOrigin']"
      And I click on element with xpath "//option[@value='UK']"
      #Optional: Gender
      And I click on element with xpath "//input[@value='female']"
      #Optional:Allowed to Contact
      Then I click on element with xpath "//input[@name='allowedToContact']"
      #Optional: Address
      And I type "Concord Lane, Santa Clara, CA" into element with xpath "//textarea[@id='address']"
      #Optional: Car make
      Then I click on element with xpath "//option[contains(text(),'Toyota')]"
      And I click on element with xpath "//option[contains(text(),'BMW')]"
      # Optional: 3rd party agreement
      Then I click on element with xpath "//*[contains(text(),'3rd party agreement')]"
      And I accept alert
      # required: Privacy Policy & Submit
      Then I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
      And I click on element with xpath "//button[@id='formSubmit']"
      #Submitted Form Results
      Then element with xpath "//div[@id='quotePageResult']" should be displayed
      And element with xpath "//b[@name='firstName']" should contain text "Rea"
      And element with xpath "//b[@name='lastName']" should contain text "Tabofunda"
      And element with xpath "//b[@name='password']" should contain text "[entered]"
      And element with xpath "//b[@name='phone']" should contain text "4080000000"
      And element with xpath "//b[@name='dateOfBirth']" should contain text "04/16/2001"
      And element with xpath "//b[@name='countryOfOrigin']" should contain text "UK"
      And element with xpath "//b[@name='gender']" should contain text "female"
      And element with xpath "//b[@name='allowedToContact']" should contain text "true"
      And element with xpath "//b[@name='address']" should contain text "Concord Lane, Santa Clara, CA"
      And element with xpath "//b[@name='carMake']" should contain text "Toyota, BMW"
      And element with xpath "//b[@name='thirdPartyAgreement']" should contain text "accepted"
      And element with xpath "//b[@name='agreedToPrivacyPolicy']" should contain text "true"
