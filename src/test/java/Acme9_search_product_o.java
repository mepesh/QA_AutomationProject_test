import Page_Objects.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Acme9_search_product_o {
    WebDriver driver;

    @BeforeTest
    public void configureBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");
    }
    @Test
    public void SearchProduct(){
        Product p = new Product(driver);
        p.verifyHome();
        p.clickProducts();
        p.verifyProductsPage();
        p.searchProduct("T-shirt");
        p.verifyResultsPage();
        // verifying products in loop

    }
}
