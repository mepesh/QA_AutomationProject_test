import Page_Objects.ContactUs;
import Page_Objects.Login;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Acme6_contactus_o {
    WebDriver driver;

    @BeforeTest
    public void configureBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }
    @Test
    public void ContactUs(){
        Login l = new Login(driver);
       // l.verifyHome();
        ContactUs c = new ContactUs(driver);
        c.ClickContactUs();
        c.VerifyGetInTouch();
        c.contactUsDetails("dipesh","dipesh.pandey42@gmail.com",
                "Inquiry", "Tell me about this");
        c.uploadFileByUrl("src/test/img/ismtFestia _card.png");
        c.clickContactSubmit();
        c.popupOk();
        c.checkSubmittedSuccess();
    }
}
