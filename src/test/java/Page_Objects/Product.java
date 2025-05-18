package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Product{
    WebDriver driver;

    public Product(WebDriver driver) {
        this.driver = driver;
    }
    public void verifyHome(){
        WebElement home = driver.findElement(By.xpath("/html[1]/body[1]/header[1]/div[1]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[1]/a[1]"));
        Assert.assertEquals(home.getText(),"Home");
    }
    // for clicking a product in homepage.
    public void homepageViewProduct(){
        WebElement homepageproduct = driver.findElement(By.xpath("//div[@class='col-sm-9 padding-right']//div[2]//div[1]//div[2]//ul[1]//li[1]//a[1]"));
        homepageproduct.click();
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
    public void hoverAddToCart(){
        WebElement productDiv = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[1]"));
        Actions action = new Actions(driver);
        action.moveToElement(productDiv).perform();

        WebElement add = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a"));
        add.click();
    }
    // https://automationexercise.com/product_details/1
    public void productDetailPage(){
        Assert.assertEquals(driver.getCurrentUrl(),"https://automationexercise.com/product_details/1");
        Assert.assertEquals(driver.findElement(By.cssSelector("div[class='product-information'] h2")).getText(),"Blue Top");
       driver.findElement(By.xpath("//p[normalize-space()='Category: Women > Tops']")).getText().contains("Category");
       driver.findElement(By.xpath("//span[normalize-space()='Rs. 500']")).getText().contains("Rs.");
       driver.findElement(By.xpath("//b[normalize-space()='Availability:']")).getText().contains("Availability");
       driver.findElement(By.xpath("//b[normalize-space()='Condition:']")).getText().contains("Condition");
       driver.findElement(By.xpath("//b[normalize-space()='Brand:']")).getText().contains("Brand");
    }
    // https://automationexercise.com/product_details/1
    // details page update quantity.
    public void updateProductQuanity(){
        driver.findElement(By.xpath("//input[@id='quantity']")).clear();
        driver.findElement(By.xpath("//input[@id='quantity']")).sendKeys("4");

    }

    //https://automationexercise.com/product_details/1
    // details page add to chart
    public void addTocart(){
        driver.findElement(By.xpath("//button[@type='button']")).click();
    }


    public void searchProduct(String productName) {
        driver.findElement(By.xpath("//input[@id='search_product']")).sendKeys(productName);
        driver.findElement(By.xpath("//button[@id='submit_search']")).click();
    }

    public void verifyResultsPage() {
        WebElement sp = driver.findElement(By.xpath("//h2[normalize-space()='Searched Products']"));
        Assert.assertEquals(sp.getText(),"SEARCHED PRODUCTS");
    }

    public void viewCart() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        // WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href='/view_cart'] u")));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u")));
        element.click();

    }
    // https://automationexercise.com/view_cart
    public void viewCartQuantity(){
        //error here
        WebElement qty = driver.findElement(By.cssSelector("#product-2 > td.cart_quantity"));
        String qtty = qty.getText();
        Assert.assertEquals(qtty,"4");
    }


    public void addToCart() {

    }

    public void addToCartSecond() {
    }
}
