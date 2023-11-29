package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    String baseurl;
    public static WebDriver driver;
    public static void openBrowser(String baseurl){
        driver=new ChromeDriver();
        driver.get(baseurl);
        driver.manage().window().maximize();

    }
    public void closeBrowser(){
        driver.quit();

    }
}
