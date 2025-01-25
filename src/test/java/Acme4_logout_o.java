import Page_Objects.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Acme4_logout_o {
    WebDriver driver;

    @BeforeTest
    public void Setup(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");

    }

    @Test
    public void Logout(){
        Login l = new Login(driver);
        l.verifyHome();
        l.clickLogin();
        l.verifyLoginPage();
        l.Login("dipesh.pandey42@gmail.com","dipesh");
        l.verifyLogin();
        l.clickLogout();
        l.verifyLoginPage();

    }
}
