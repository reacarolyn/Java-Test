package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class WebDriverHwStepDefs {
    @Given("I will open webpage url")
    public void iWillOpenWebpageUrl() throws InterruptedException {
        getDriver().navigate().to("https://home.sccgov.org/home");
        Thread.sleep(2000);
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
    }

    @Given("I open {string}")
    public void iOpen(String webPage) {
        if (webPage.equalsIgnoreCase("coursera")){
            getDriver().get("https://www.coursera.org//");
        } else if (webPage.equalsIgnoreCase("codecademy")) {
            getDriver().get("https://www.codecademy.com/");
        } else if (webPage.equalsIgnoreCase("Udemy")) {
            getDriver().get("https://www.udemy.com/");
        } else {
            System.out.println("Unknown page");
        }
    }
    @And("I print out url and title")
    public void iPrintOutUrlAndTitle() {
        System.out.println(getDriver().getTitle());
        System.out.println(getDriver().getCurrentUrl());
    }

    @Given("I will open {string} then then {string} then {string}")
    public void iWillOpenThenThenThen(String webSite1, String webSite2, String webSite3) throws InterruptedException {
        String [] webSites = {webSite1, webSite2, webSite3};
       //for loop
        for (int i=0; i<webSites.length; i++){
            System.out.println(webSites[i]);
            getDriver().get(webSites[i]);
            Thread.sleep(1000);
        }
        // for each
        for (String webSite: webSites) {
            System.out.println(webSite);
            getDriver().get(webSite);
            Thread.sleep(1000);
        }
    }

    @Given("I  will open {string} page")
    public void iWillOpenPage(String webSite4) {
        getDriver().get("https://skryabin.com/market/quote.html");
    }

    @When("I fill all the required fields")
    public void iFillAllTheRequiredFields() {
        //WebDriverStepDefs requiredEl = new WebDriverStepDefs();
        WebElement name=getDriver().findElement(By.xpath("//input[@id='name']"));
        WebElement firstName=getDriver().findElement(By.xpath("//input[@id='firstName']"));
        WebElement lastName=getDriver().findElement(By.xpath("//input[@id='lastName']"));
        WebElement saveName=getDriver().findElement(By.xpath("//span[contains(text(),'Save')]"));
        WebElement userName=getDriver().findElement(By.xpath("//input[@name='username']"));
        WebElement email=getDriver().findElement(By.xpath("//input[@name='email']"));
        WebElement password=getDriver().findElement(By.xpath("//input[@name='password']"));
        WebElement confirmPassword=getDriver().findElement(By.xpath("//input[@name='confirmPassword']"));
        WebElement agree=getDriver().findElement(By.xpath("//input[@name='agreedToPrivacyPolicy']"));
        name.click();
        firstName.sendKeys("Rea");
        lastName.sendKeys("Tabofunda");
        saveName.click();
        userName.sendKeys("reatabofunda");
        email.sendKeys("rtabofunda@gmail.com");
        password.sendKeys("tester123");
        confirmPassword.sendKeys("tester123");
        agree.click();
    }

    @And("I will submit the Quote form")
    public void iWillSubmitTheQuoteForm() {
        WebElement submit=getDriver().findElement(By.xpath("//button[@id='formSubmit']"));
        submit.submit();


    }


    @Given("I will provide inputs to all the elements")
    public void iWillProvideInputsToAllTheElements() {
        iWillOpenPage("https://skryabin.com/market/quote.html");
        //required fields - name, username, email, password, confirm password, Privacy Policy
        iFillAllTheRequiredFields();
        //Non-required:Phone number, , Country of Origin, Gender, Address, Car Make, Allowed to Contact
        WebElement phone=getDriver().findElement(By.xpath("//input[@name='phone']"));
        WebElement dob=getDriver().findElement(By.xpath("//input[@id='dateOfBirth']"));
        Select year = new Select(getDriver().findElement(By.xpath("//select[@data-handler='selectYear']")));
        WebElement month=getDriver().findElement(By.xpath("//select[@data-handler='selectMonth']"));
        WebElement monthSelect=getDriver().findElement(By.xpath("//option[@value='4']"));
        WebElement daySelect=getDriver().findElement(By.xpath("//a[contains(text(),'16')]"));
        WebElement country=getDriver().findElement(By.xpath("//a[contains(text(),'16')]"));
        WebElement countrySelect=getDriver().findElement(By.xpath("//option[@value='Canada']"));
        WebElement gender=getDriver().findElement(By.xpath("//input[@value='female']"));
        WebElement allowedToContact=getDriver().findElement(By.xpath("//input[@name='allowedToContact']"));
        WebElement address=getDriver().findElement(By.xpath("//textarea[@id='address']"));
        WebElement carMake1=getDriver().findElement(By.xpath("//option[contains(text(),'Toyota')]"));
        WebElement carMake2=getDriver().findElement(By.xpath("//option[contains(text(),'BMW')]"));
        WebElement thirdParty=getDriver().findElement(By.xpath("//*[contains(text(),'3rd party agreement')]"));
        Alert thirdPartyAlert = getDriver().switchTo().alert();

        phone.sendKeys("408-000-1234");
        dob.click();
        year.selectByVisibleText("1995");

        month.click();
        monthSelect.click();
        daySelect.click();
        country.click();

        countrySelect.click();
        gender.click();
        allowedToContact.click();
        address.sendKeys("Santa Clara, CA 95052");
        carMake1.click();
        carMake2.click();
        thirdParty.click();
        thirdPartyAlert.accept();
        iWillSubmitTheQuoteForm();
    }

    //Verify Submitted Application
    void verifySubmittedFields(String ans) {
        getDriver().findElement(By.xpath(ans)).isDisplayed();
    }
    @Given("I verify the Quote form")
    public void iVerifyTheQuoteForm() {
        iWillOpenPage("https://skryabin.com/market/quote.html");
        iWillProvideInputsToAllTheElements();
        WebDriverWait wait = new WebDriverWait(getDriver(), 180, 200);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/div[@id='quotePageResult']")));
        // array for answers
        String [] submittedAnswers ={"Rea", "Tabofunda", "Rea Tabofunda", "Canada", "reatabofunda", "rtabofunda@gmail.com", "[entered]",
                "female", "true", "Santa Clara, CA 95051", "Toyota, BMW", "true", "accepted" };
        // for loop
        for (int i=0; i<submittedAnswers.length; i++){
            verifySubmittedFields(submittedAnswers[i]);
        }
    }

}
