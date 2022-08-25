import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Navigate {
    @Test
    public void Navigate_test() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        String title = driver.getTitle();
        System.out.println("the title of the page is :"+title);
        String currentUrl = driver.getCurrentUrl();
        System.out.println("the URL of the page is :"+currentUrl);
        String pageSource = driver.getPageSource();
        System.out.println("the source code of the page is :"+pageSource);
        Thread.sleep(2000);
        driver.navigate().to("https://www.amazon.in/");
        Thread.sleep(3000);
        driver.navigate().back();
        Thread.sleep(3000);
        driver.navigate().forward();
        Thread.sleep(3000);
        driver.navigate().refresh();
        Thread.sleep(3000);
        driver.close();
    }
}
