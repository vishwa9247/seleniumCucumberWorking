package StepDefs;

import cucumber.api.java8.En;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyStepdefs implements En
{
    private WebDriver driver;

    private void setup()
    {
        System.setProperty( "webdriver.chrome.driver", "resources/chromedriver.exe" );
        driver = new ChromeDriver();
    }

    private void quitApp()
    {
        driver.quit();
    }

    public MyStepdefs()
    {


        When( "^I enter valid credentials$", () ->
        {
            driver.findElement( By.id( "username" ) ).sendKeys( "tomsmith" );
            driver.findElement( By.id( "password" ) ).sendKeys( "SuperSecretPassword!" );
            driver.findElement( By.xpath( "//button[@class='radius']" ) ).click();


        } );
        Given( "^I am in the login page of the Para Bank Application$", () ->
        {
//            System.setProperty( "webdriver.chrome.driver", "resources/chromedriver.exe" );
//            driver = new ChromeDriver();
            setup();
            driver.get( "https://the-internet.herokuapp.com/login" );
        } );
        Then( "^I should be taken to the Overview page$", () ->
        {
            driver.findElement( By.id( "flash" ) ).isDisplayed();
//            driver.findElement(By.className("button secondary radius")).click();
            quitApp();


        } );
    }
}
