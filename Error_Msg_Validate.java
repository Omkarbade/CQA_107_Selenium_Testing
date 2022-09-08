import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Error_Msg_Validate {
    String actualerrormsg;
    String expectederrormsg = "The email address you entered isn't connected to an account. Find your account and log in.";
    @Test
    public void error_msg() throws InterruptedException{

        System.setProperty("webdriver.gecko.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='email'] ")).sendKeys("Test123@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("omkarbade3799");
        driver.findElement(By.xpath("//button[@name='login']")).click();
        Thread.sleep(3000);
        actualerrormsg = driver.findElement(By.xpath("//div[@class='_9ay7']")).getText();
        Assert.assertEquals(actualerrormsg,expectederrormsg);
        System.out.println("Test passed");

    }
}
