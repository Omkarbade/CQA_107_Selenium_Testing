
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.testng.annotations.Test;

public class Selenium_Test {
    @Test
    public void chrome_browser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void microsoft() throws InterruptedException {
        System.setProperty("webdriver.msedgedriver.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }
    @Test
    public void firefox() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
    }

}
