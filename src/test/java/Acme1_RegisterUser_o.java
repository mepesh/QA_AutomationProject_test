import Page_Objects.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Acme1_RegisterUser_o {

    WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }
    @Test
    public void RegisterUser(){
        Login l = new Login(driver);

        l.clickLogin();

    }
}
