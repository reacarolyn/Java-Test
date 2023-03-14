package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class WebDriverStepDefs {
    @Given("I open any url")
    public void iOpenAnyUrl() throws InterruptedException {
        //using get()
        getDriver().get("https://skryabin.com/market/quote.html");
        //browser will sleep or wait
        Thread.sleep(2000);
        //using navigate.to()
        getDriver().navigate().to("https://skryabin.com/market/quote.html");
        Thread.sleep(2000);
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
    }

    @Given("I go to {string}")
    public void iGoTo(String page) {
        if (page.equalsIgnoreCase("google")){
            getDriver().get("https://www.google.com/");
        } else if (page.equalsIgnoreCase("yahoo")) {
            getDriver().get("https://www.yahoo.com/");
        } else {
            System.out.println("Unknown page");
        }
    }

    @And("I print details")
    public void iPrintDetails() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
    }

    @Given("I open {string} then then {string} then {string}")
    public void iOpenThenThenThen(String url1, String url2, String url3) throws InterruptedException {
        String[] urls={url1,url2,url3};
        for (String url:urls) {
            System.out.println(url);
            getDriver().get(url);
            Thread.sleep(1000);
        }
    }

    @Given("I open {string} page")
    public void iOpenPage(String arg0) {
        getDriver().get("https://skryabin.com/market/quote.html");
    }

    @When("I fill out first name {string} and last name {string}")
    public void iFillOutFirstNameAndLastName(String firstName, String lastName) {
        getDriver().findElement(By.xpath("//input[@id='name']")).click();
        getDriver().findElement(By.xpath("//input[@id='firstName']")).sendKeys(firstName);
        getDriver().findElement(By.xpath("//input[@id='lastName']")).sendKeys(lastName);
        getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
    }

    @And("I fill out required fields")
    public void iFillOutRequiredFields() {
        WebElement userName=getDriver().findElement(By.xpath("//input[@name='username']"));
        userName.sendKeys("reatabofunda");
        WebElement email=getDriver().findElement(By.xpath("//input[@name='email']"));
        email.sendKeys("rtabofunda@gmail.com");
        WebElement password=getDriver().findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("tester123");
        WebElement confirmPassword=getDriver().findElement(By.xpath("//input[@name='confirmPassword']"));
        confirmPassword.sendKeys("tester123");
        WebElement agree=getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"));
        agree.click();
        WebElement submit=getDriver().findElement(By.xpath("//button[@id='formSubmit']"));
        submit.submit();
    }

    @Then("I assert required fields")
    public void iAssertRequiredFields() throws InterruptedException {
        WebElement actualPageResult =getDriver().findElement(By.xpath("//div[@id='quotePageResult']"));
        assertThat(actualPageResult.isDisplayed()).isTrue();
        String actualPw = getDriver().findElement(By.xpath("//b[@name='password']")).getText();
        assertThat(actualPw).isEqualToIgnoringCase("[entered]");

        String actualUsername = getDriver().findElement(By.xpath("//b[@name='username']")).getText();
        assertThat(actualUsername).isEqualToIgnoringCase("reatabofunda");

        String actualEmail = getDriver().findElement(By.xpath("//b[@name='email']")).getText();
        assertThat(actualEmail).isEqualToIgnoringCase("rtabofunda@gmail.com");
        Thread.sleep(1000);
        //return button
        getDriver().findElement(By.xpath("//button[@id='return']")).click();

    }

    @And("I fill out contact name {string} and contact phone {string} in additional information")
    public void iFillOutContactNameAndContactPhoneInAdditionalInformation(String contName, String contPhone) throws InterruptedException {

        getDriver().switchTo().frame("additionalInfo");
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).click();
        getDriver().findElement(By.xpath("//input[@id='contactPersonName']")).sendKeys(contName);
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).click();
        getDriver().findElement(By.xpath("//input[@id='contactPersonPhone']")).sendKeys(contPhone);
        getDriver().switchTo().defaultContent();
    }

}
