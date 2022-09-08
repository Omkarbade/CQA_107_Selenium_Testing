import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class VerifyPage {

    public static WebDriver driver;
    @BeforeClass
    public void launch() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void VerifyhomepageUsingTitle() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("omkarbade");
        driver.findElement(By.name("pass")).sendKeys("Test123");
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);
        String expectedTitle = "facebook";
        String actualTitle = driver.getTitle();
//If actual title contains "Enter Time" text then home page is displayed.
        if (actualTitle.contains(expectedTitle)) {
            System.out.println("Home page is displayed");
        } else{
            System.out.println("Home page is NOT displayed");
        }
    }
    @Test
    public void VerifyhomepageUsingUrl() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("omkar bade");
        driver.findElement(By.name("pass")).sendKeys("Test123");
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);
        String expectedUrl = "https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();
//If actual title contains "Enter Time" text then home page is displayed.
        if (actualUrl.contains(expectedUrl)) {
            System.out.println("Home page is displayed");
        } else{
            System.out.println("Home page is NOT displayed");
        }
    }

    @Test
    public void VerifyhomepageUsingUniqueElement() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("omkar bade");
        driver.findElement(By.name("pass")).sendKeys("Test133");
        driver.findElement(By.name("login")).click();
        Thread.sleep(3000);
        WebElement WatchBtn = driver.findElement(By.xpath("//a[@aria-label='Watch']"));  ;
        if (WatchBtn.isDisplayed()) {
            System.out.println("Watch btn is displayed");
        } else{
            System.out.println("Watch btn is NOT displayed");
        }
    }

    }
