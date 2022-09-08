import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Waits {
    @Test
    public void implicitly() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("Test123@gmail.com");
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.name("pass")).sendKeys("Test@12345");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void Expilcity() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("Test123@gmail.com");
        driver.findElement(By.id("email")).clear();
        Thread.sleep(2000);
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("email")));
        email.sendKeys("Omkar123@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("Test@12345");
        driver.findElement(By.name("login")).click();
    }

}
