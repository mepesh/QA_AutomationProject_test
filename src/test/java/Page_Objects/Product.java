package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Product{
    WebDriver driver;

    public Product(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyHome(){
        WebElement home = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]"));
        Assert.assertEquals(home.getText(),"Home");
    }
    public void clickProducts(){
        driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[2]/a[1]")).click();
    }
    public void verifyProductsPage(){
        WebElement text = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertEquals(text.getText(),"ALL PRODUCTS");
    }

    public void clickProductDetails(){
        driver.findElement(By.cssSelector("a[href='/product_details/1']")).click();
    }
    public void productDetailPage(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/product_details/1");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='product-information'] h2")).getText(),"Blue Top");
       driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']")).getText().contains("Category");
       driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']")).getText().contains("Rs.");

    }


}
