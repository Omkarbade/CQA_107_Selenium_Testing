import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Facebook {
    public static WebDriver driver;
@BeforeClass
public void launch(){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().maximize();
}
    @Test
    public void login_Test() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).sendKeys("Test123@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.id("email")).clear();
        Thread.sleep(2000);
        driver.findElement(By.name("pass")).sendKeys("Test@12345");
        driver.findElement(By.name("login")).click();
    }

    @Test
    public void Sign_up_Test() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.linkText("Create New Account")).click();
        Thread.sleep(6000);

        driver.findElement(By.name("firstname")).sendKeys("Omkar");
        Thread.sleep(2000);
        driver.findElement(By.name("lastname")).sendKeys("Bade");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_email__")).sendKeys("1234567890");
        Thread.sleep(2000);
        driver.findElement(By.name("reg_passwd__")).sendKeys("111111111");
        Thread.sleep(2000);
        Select date = new Select(driver.findElement(By.id("day")));
        date.selectByVisibleText("14");
        Thread.sleep(2000);

        Select month = new Select(driver.findElement(By.id("month")));
        month.selectByVisibleText("Aug");
        Thread.sleep(2000);

        Select year = new Select(driver.findElement(By.id("year")));
        year.selectByVisibleText("1999");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.name("websubmit")).click();
        driver.close();
    }
    @Test
    public void login_Test_xpath() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='email'] ")).sendKeys("Test123@gmail.com");
        Thread.sleep(2000);
//        driver.findElement(By.xpath("//input[@id='email'] ")).clear();
//        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='pass']")).sendKeys("omkarbade3799");
        driver.findElement(By.xpath("//button[@name='login']")).click();
    }

    @Test
    public void sign_up_xpath() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Omkar");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Bade");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys("1234567890");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name='reg_passwd__']")).sendKeys("111111111");
        Thread.sleep(2000);
        Select date = new Select(driver.findElement(By.xpath("//select[@id='day']")));
        date.selectByVisibleText("14");
        Thread.sleep(2000);

        Select month = new Select(driver.findElement(By.xpath("//select[@id='month']")));
        month.selectByVisibleText("Aug");
        Thread.sleep(2000);

        Select year = new Select(driver.findElement(By.xpath("//select[@id='year']")));
        year.selectByVisibleText("1999");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//label[contains(text(),'Male')]")).click();
        Thread.sleep(2000);
        //driver.findElement(By.xpath("//button[@name='websubmit']")).click();
        driver.close();
    }
    @Test
    public void login_cssSelector() throws InterruptedException {

        driver.get("https://www.facebook.com/");
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#email")).sendKeys("Test123@gmail.com");
        Thread.sleep(2000);
//        driver.findElement(By.id("email")).clear();
//        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#pass")).sendKeys("Test@12345");
        driver.findElement(By.cssSelector("button[name ='login']")).click();
    }


}
