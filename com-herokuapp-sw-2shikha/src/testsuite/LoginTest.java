package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {

    String baseurl = "http://the-internet.herokuapp.com/login";

    @Before
    public void openBrowser() {
        openBrowser(baseurl);
    }
    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials()
    {
        //Enter “tomsmith” username
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
       //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//form[@name='login']/button/i[1]")).click();
        String actualResult= driver.findElement(By.xpath("//div[@id='content']/div[1]/h2")).getText();
        String expectedResult="Secure Area";
        Assert.assertEquals(actualResult,expectedResult);


    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //Enter “tomsmith1” username
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        //Enter “SuperSecretPassword!” password
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//form[@name='login']/button/i[1]")).click();
        //* Verify the error message “Your username is invalid
        String actualResult=driver.findElement(By.xpath("/html[@class='no-js']/body/div[1]")).getText();
        System.out.println(actualResult);
        String expectedResult="Your username is invalid!\n" +
                "×";
        System.out.println(expectedResult);
       Assert.assertEquals(expectedResult,actualResult);
        }
        @Test
    public void verifyThePasswordErrorMessage(){
        //Enter “tomsmith” username
            driver.findElement(By.id("username")).sendKeys("tomsmith");
            //Enter “SuperSecretPassword” password
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
            //Click on ‘LOGIN’ button
            driver.findElement(By.xpath("//form[@name='login']/button/i[1]")).click();

      String actualResult=driver.findElement(By.xpath("//html[@class='no-js']/body/div[1]/div[1]/div")).getText();
            System.out.println(actualResult);
            String expectedResult="Your password is invalid!\n" +
                    "×";
            System.out.println(expectedResult);
            Assert.assertEquals(expectedResult,actualResult);







    }
    @After
    public void endTest(){
      //  closeBrowser();
    }
}
