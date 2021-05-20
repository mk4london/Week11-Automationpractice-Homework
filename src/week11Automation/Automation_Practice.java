package week11Automation;

/*Open url : http://automationpractice.com/index.php
 *Click on Sign In
 *Enter correct Email in Email field
 *Enter wrong Password in Password field
 *Click on Sign In button.
 *Expected Result:
 *Error Message “There is 1 error”
 *
 */


import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Automation_Practice {
    WebDriver driver;

    @Before
    // Url Set uo
    public void uRL_set_up() {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://automationpractice.com");

    }
    @Test
    // User Can not sign in and get the error : "There is 1 error"
    public void verify_User_Can_Not_Sign_In(){
        driver.findElement(By.xpath("//div[@class='header_user_info']/a")).click();
        String expected_results= "AUTHENTICATION";
        WebElement message = driver.findElement(By.xpath("//h1"));
        String actual_results = message.getText();
        Assert.assertEquals("",actual_results,expected_results);
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("abc@gmail.com");
        driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys("12345");
        driver.findElement(By.xpath("//button[@id='SubmitLogin']")).click();
        String expected_results2= "There is 1 error";
        WebElement message2 = driver.findElement(By.xpath("//div[@class='alert alert-danger']/p"));
        String actual_results2 = message2.getText();
        Assert.assertEquals("",actual_results2,expected_results2);

    }
    // after block
    @After // j unit after
    public void tearDown() {

        driver.quit();
    }

}
