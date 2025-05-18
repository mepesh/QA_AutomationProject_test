import Page_Objects.Product;
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
        Product p = new Product(driver);
        p.homepageViewProduct();
        p.productDetailPage();
        p.updateProductQuanity();
        p.addTocart();
        p.viewCart();
        p.viewCartQuantity();


    }
    @AfterTest
    public void closeBrrowser(){
        driver.close();
    }

}
