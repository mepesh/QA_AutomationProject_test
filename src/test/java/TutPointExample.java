import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import java.io.File;

public class TutPointExample {
    WebDriver driver;
    @BeforeTest
    public void OpenBrowser(){
      //  System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void PracticeForm(){
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
        // name
        WebElement nameTxtBox = driver.findElement(By.xpath("//*[@id=\"name\"]"));
        nameTxtBox.sendKeys("Dipesh Pandey");
        // Email
        WebElement emailField = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        emailField.sendKeys("dipesh.pandey42@gmail.com");
        //mobile
        WebElement mblField = driver.findElement(By.xpath("//*[@id=\"mobile\"]"));
        mblField.sendKeys("9847301001");

        //dob
        WebElement dobField = driver.findElement(By.xpath("//*[@id=\"dob\"]"));
        dobField.sendKeys("12/26/1992");

        WebElement subField = driver.findElement(By.xpath("//*[@id=\"subjects\"]"));
        subField.sendKeys("Maths");

        //file upload
        File uploadFile = new File("src/test/img/ismtFestia _card.png");
        WebElement fileUpload = driver.findElement(By.id("picture"));
        fileUpload.sendKeys(uploadFile.getAbsolutePath());
/*
        //selector state
        WebElement stateDropdown = driver.findElement(By.id("state"));
        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByVisibleText("NCR");
        //selector city
        WebElement cityDropdown = driver.findElement(By.id("city"));
        Select citySelector = new Select(cityDropdown);
        citySelector.selectByVisibleText("Lucknow");
*/
        //login button
      //  WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[11]/input"));
      //  loginbutton.click();

    }


}
