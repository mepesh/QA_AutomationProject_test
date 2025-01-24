import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RegisterUser {
    WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "src/test/ChromeDriver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com/");
    }

    @Test
    public void registerUser(){
        //verify homepage is visible
        WebElement homePage = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        String actualResults =  homePage.getText();
        Assert.assertEquals(actualResults,"Home");

        WebElement signup_login = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a"));
        signup_login.click();

        //verify New User Signup is visible
        WebElement a = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2"));
        String actualResult = a.getText();
        Assert.assertEquals(actualResult,"New User Signup!");


        WebElement name = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        name.sendKeys("Shreemal Sitikhu");

        WebElement email = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        email.sendKeys("shreemalsitikhu@gmail.com");

        WebElement signup = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signup.click();

        //verify ENTER ACCOUNT INFORMATION is visible
        WebElement b = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2/b"));
        String c = b.getText();
        Assert.assertEquals(c,"ENTER ACCOUNT INFORMATION");

        // Enter Account Information
        WebElement gender = driver.findElement(By.id("id_gender1"));
        gender.click();

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("cmalctkhu");

        WebElement day = driver.findElement(By.id("days"));
        // Create a Select instance for the dropdown
        Select selectDay = new Select(day);
        // Select a specific day by visible text
        selectDay.selectByVisibleText("6");

        WebElement month = driver.findElement(By.id("months"));
        Select selectMonth = new Select(month);
        selectMonth.selectByVisibleText("February");

        WebElement year = driver.findElement(By.id("years"));
        Select selectYear = new Select(year);
        selectYear.selectByVisibleText("2001");

        WebElement newsletter = driver.findElement(By.id("newsletter"));
        newsletter.click();

        WebElement offers = driver.findElement(By.id("optin"));
        offers.click();

        //Address Information
        WebElement firstname = driver.findElement(By.id("first_name"));
        firstname.sendKeys("Shreemal");

        WebElement lastname = driver.findElement(By.id("last_name"));
        lastname.sendKeys("Sitikhu");

        WebElement company = driver.findElement(By.id("company"));
        company.sendKeys("TechAxis");

        WebElement address1 = driver.findElement(By.id("address1"));
        address1.sendKeys("Goldmodi Bhaktapur");

        WebElement address2 = driver.findElement(By.id("address2"));
        address2.sendKeys("Bagmati Nepal");

        WebElement country = driver.findElement(By.id("country"));
        Select selectCountry = new Select(country);
        selectCountry.selectByVisibleText("India");

        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("Bagmati");

        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("Kathmandu");

        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("44600");

        WebElement mobile = driver.findElement(By.id("mobile_number"));
        mobile.sendKeys("9876543210");

        WebElement CreateAccount = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button"));
        CreateAccount.submit();

        //verify ACCOUNT CREATED! is visible
        WebElement d = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        String e = d.getText();
        Assert.assertEquals(e,"ACCOUNT CREATED!");

        WebElement AccountCreateContinue = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        AccountCreateContinue.click();

        //verify Logged in as Shreemal Sitikhu
        WebElement loggedinAsUsername = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        String actualUsername = loggedinAsUsername.getText();
        System.out.println(loggedinAsUsername.getAriaRole());
        Assert.assertEquals(actualUsername,"Logged in as Shreemal Sitikhu");

        //Delete Account
        WebElement deleteAccount = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a"));
        deleteAccount.click();

        //verify ACCOUNT DELETED! is visible
        WebElement accountDeleted = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2/b"));
        String actualAccountDeletedMessage = accountDeleted.getText();
        Assert.assertEquals(actualAccountDeletedMessage,"ACCOUNT DELETED!");

        WebElement accountDeleteContinue = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/a"));
        accountDeleteContinue.click();

    }
}
