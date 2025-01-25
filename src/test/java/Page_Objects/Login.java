package Page_Objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver){
        this.driver = driver;
    }

    public void verifyHome(){
        WebElement home = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a"));
        Assert.assertEquals(home.getText(),"Home");
    }
    public void clickLogin(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
    }
    public void verifyLoginPage(){
        WebElement welcome = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2"));
        Assert.assertEquals(welcome.getText(),"Login to your account");
    }
    public void Login(String username, String password){
        WebElement u = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]"));
        u.sendKeys(username);
        WebElement p = driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]"));
        p.sendKeys(password);
        driver.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();

    }
    public void verifyLogin(){
        WebElement verify = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
        Assert.assertEquals(verify.getText(),"Logged in as dipesh");
    }
    public void clickLogout(){
        driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();
    }


}
