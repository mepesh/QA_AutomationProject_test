import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Acme13_quantity_verify
{
    WebDriver driver;
    @BeforeTest
    public void configureBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver");
        //  System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }
    @Test
    public void QuantityVerify(){

    }
    @AfterTest
    public void closeBrrowser(){
        driver.close();
    }

}
