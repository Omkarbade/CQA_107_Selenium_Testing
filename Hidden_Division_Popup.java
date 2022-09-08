import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Hidden_Division_Popup {
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://www.cleartrip.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//*[name()='svg'][@class='t-all ml-2'])[1]")).click();
        driver.findElement(By.xpath("(//div[@class='Day-grid flex flex-middle flex-column flex-top'])[16]")).click();
    }
}
