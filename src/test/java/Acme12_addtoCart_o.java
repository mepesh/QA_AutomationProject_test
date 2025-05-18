import Page_Objects.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class Acme12_addtoCart_o {
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
    public void AddToCart(){
        Product p = new Product(driver);
       // p.verifyHome();
        p.clickProducts();
        //hovers add to cart
        p.hoverAddToCart();
        p.addToCart();
        try {
            sleep(200);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //p.addToCartSecond();
        p.viewCart();

    }

    @AfterTest
    public void closeBrowser(){
       driver.quit();
    }
}
