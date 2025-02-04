import Page_Objects.Register;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Acme5_registerError_o {
    WebDriver driver;

    @BeforeTest
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }
    @Test
    public void RegisterwithInvalid(){
        Register r = new Register(driver);
        r.verifyHome();
        r.clickRegister();
        r.checkSignupVisible();
        r.signup("dipesh","dipesh.pandey42@gmail.com");
        r.clickSignupButton();
        r.verifyErrorSignup();

    }
}
