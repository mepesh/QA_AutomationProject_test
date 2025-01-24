import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
public class GoogleClassTest {
    WebDriver driver;
    @BeforeClass

    public void Setup(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.tutorialspoint.com/selenium/practice/selenium_automation_practice.php");
    }

    @Test
    public void tutTest(){

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

        //subject
        //selector dropdown
        WebElement stateDropdown = driver.findElement(By.id("state"));

        Select stateSelect = new Select(stateDropdown);
        stateSelect.selectByVisibleText("Haryana");

        WebElement cityDropdown = driver.findElement(By.id("city"));

        Select citySelector = new Select(cityDropdown);
        citySelector.selectByVisibleText("Lucknow");

        //login button
        WebElement loginbutton = driver.findElement(By.xpath("//*[@id=\"practiceForm\"]/div[11]/input"));
        loginbutton.click();

    }


    @AfterClass
    public void CloseBrowser(){

    }

}
