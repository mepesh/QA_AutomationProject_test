package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.io.File;

public class ContactUs {
    WebDriver driver;

    public ContactUs(WebDriver driver) {
        this.driver = driver;
    }
    public void ClickContactUs(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")).click();
    }
    public void VerifyGetInTouch(){
        WebElement text = driver.findElement(By.xpath("//*[@id=\"contact-page\"]/div[2]/div[1]/div/h2"));
        Assert.assertEquals(text.getText(),"GET IN TOUCH");
    }

    public void contactUsDetails(String name, String email, String subject, String message){
        driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[1]/div[3]/form[1]/div[1]/input[1]")).sendKeys(name);
        driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys(email);
        driver.findElement(By.xpath("//input[@placeholder='Subject']")).sendKeys(subject);
        driver.findElement(By.xpath("//textarea[@id='message']")).sendKeys(message);
    }


    public void uploadFileByUrl(String url) {
        File file = new File(url);
        driver.findElement(By.xpath("//input[@name='upload_file']")).sendKeys(file.getAbsolutePath());
    }

    public void clickContactSubmit(){
        driver.findElement(By.xpath("//input[@name='submit']")).click();
    }
}
