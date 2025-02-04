package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Register {
    WebDriver driver;

    public Register(WebDriver driver){
        this.driver=driver;
    }
    public void clickRegister(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
    }

    public void verifyHome(){
        String home = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")).getText();
        Assert.assertEquals(home,"Home");
    }

    public void checkSignupVisible(){
        String signup = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/h2")).getText();
        Assert.assertEquals(signup,"New User Signup!");
    }

    public void signup(String name, String mail) {
        WebElement n = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]"));
        n.sendKeys(name);
        WebElement e = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]"));
        e.sendKeys(mail);
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
    }
    public void clickSignupButton(){
        WebElement signupbtn = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button"));
        signupbtn.click();
    }

    public void verifyErrorSignup(){
        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p"));
        Assert.assertEquals(errorMessage.getText(),"Email Address already exist!");
    }

}
