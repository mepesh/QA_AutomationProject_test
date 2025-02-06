import Page_Objects.Links;
import Page_Objects.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Acme8_product_details_o {
    WebDriver driver;

    @BeforeTest
    public void configureBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }
    @Test
    public void productPage(){
        Product p = new Product(driver);
        p.verifyHome();
        p.clickProducts();
        p.verifyProductsPage();
        p.clickProductDetails();
        p.productDetailPage();



    }
    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}
