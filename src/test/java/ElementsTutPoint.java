import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;

import static java.lang.Thread.sleep;

public class ElementsTutPoint {
    WebDriver driver;
    @BeforeTest
    public void OpenBrowser(){
        System.setProperty("webdriver.chrome.driver","src/test/ChromeDriver/chromedriver.exe");

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.tutorialspoint.com/selenium/practice/text-box.php");
    }
    @Test
    public void TextBox(){
        WebElement fullTxtBox = driver.findElement(By.id("fullname"));
        System.out.println(fullTxtBox.getAriaRole());
        fullTxtBox.sendKeys("Dipesh Pandey");
        //email
        WebElement emailTxtBox = driver.findElement(By.id("email"));
        emailTxtBox.sendKeys("dipesh.pandey42@gmail.com");
        //textarea
        WebElement addressTxtarea = driver.findElement(By.id("address"));
        addressTxtarea.sendKeys("My address is Nepal, Rupendehi district");
        //password
        WebElement passTxtarea = driver.findElement(By.id("password"));
        passTxtarea.sendKeys("password123");
        //submit
        WebElement loginForm = driver.findElement(By.name("TextForm"));
       // loginForm.submit();
    }

    @Test
    public void checkBox(){
        WebElement linkCheckBoxSection = driver.findElement(By.xpath("//*[@id=\"navMenus\"]/li[2]/a"));
        linkCheckBoxSection.click();
        //checkbox
        WebElement lbl1Chkbox = driver.findElement(By.id("c_bs_1"));
        lbl1Chkbox.click();
        //checkbox
        WebElement lbl2Chkbox = driver.findElement(By.id("c_bs_2"));
        lbl2Chkbox.click();

    }
    @Test
    public void radioButton(){
        //next section
        WebElement linkRadioButtonSection = driver.findElement(By.xpath("//*[@id=\"navMenus\"]/li[3]/a"));
        linkRadioButtonSection.click();
        //checkbox
        WebElement yesRadiobtn = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[1]/input"));
        yesRadiobtn.click();
    }

    @Test
    public void webTables() throws Exception{

        WebElement menuSectionLink = driver.findElement(By.xpath("//*[@id=\"navMenus\"]/li[4]/a"));
        menuSectionLink.click();
        //Add button
        WebElement addButton = driver.findElement(By.xpath("/html/body/main/div/div/div[2]/form/div[1]/span[1]/button"));
        addButton.click();

        sleep(1000);
        //popup options
        WebElement firstTxtbox = driver.findElement(By.xpath("//*[@id=\"firstname\"]"));
        firstTxtbox.sendKeys("Dipesh ");
        // popup email
        WebElement emailTxtbox = driver.findElement(By.id("email"));
        emailTxtbox.sendKeys("dipesh.pandey42@gmail.com");
        // lastname
        WebElement lastTxtbox = driver.findElement(By.id("lastname"));
        lastTxtbox.sendKeys("Pandey");

        // age
        WebElement ageTxtbox = driver.findElement(By.id("age"));
        ageTxtbox.sendKeys("three");

        // salary
        WebElement salaryTxtbox = driver.findElement(By.id("salary"));
        salaryTxtbox.sendKeys("dajksgdfjasfbjbaijsfbasjkfga");

        // salary
        WebElement departmentTxtbox = driver.findElement(By.id("deparment"));
        departmentTxtbox.sendKeys("dajksgdfjasfbjbaijsfbasjkfga");

        WebElement registerForm = driver.findElement(By.id("RegisterForm"));
        registerForm.submit();
        //check if collapse or expand
        WebElement elementLinkOpen = driver.findElement(By.xpath("//*[@id=\"headingOne\"]/button"));
        String domValue = elementLinkOpen.getDomAttribute("aria-expanded");

        if(domValue=="false"){
            System.out.println(domValue);
            elementLinkOpen.click();
        }else{

        }


    }

    @Test
    public void Upload(){
        WebElement linkUpload = driver.findElement(By.xpath("//*[@id=\"navMenus\"]/li[8]/a"));
        linkUpload.click();

        File uploadFile = new File("src/test/img/ismtFestia _card.png");
        WebElement fileUpload = driver.findElement(By.id("uploadFile"));
        fileUpload.sendKeys(uploadFile.getAbsolutePath());
    }


}
