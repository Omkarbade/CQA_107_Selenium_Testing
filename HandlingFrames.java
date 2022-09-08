import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HandlingFrames {
    @Test
    public void frame() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("C:\\Users\\OMKAR BADE\\Desktop\\Page2 - Copy.html");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        Thread.sleep(2000);

//			using index of the frame - [ int value] [ index of frames starts with zero]
//			driver.switchTo().frame(0);
//			driver.findElement(By.id("t1")).sendKeys("Aman");
//			driver.switchTo().defaultContent();
//			driver.findElement(By.id("t2")).sendKeys("Rahul");
//			Thread.sleep(2000);


//			using id attribute of the frame -string
//			driver.switchTo().frame("f1");
//			driver.findElement(By.id("t1")).sendKeys("manish");
//			driver.switchTo().defaultContent();
//			driver.findElement(By.id("t2")).sendKeys("manish");
//			Thread.sleep(2000);

//			using name attribute of the frame -string
//			driver.switchTo().frame("n1");
//			driver.findElement(By.id("t1")).sendKeys("hello");
//			driver.switchTo().defaultContent();
//			driver.findElement(By.id("t2")).sendKeys("hello");
//			Thread.sleep(2000);

//			using address of the frame -webelement
        WebElement f = driver.findElement(By.className("c1"));
        driver.switchTo().frame(f);
        driver.findElement(By.id("t1")).sendKeys("d");
        driver.switchTo().defaultContent();
        driver.findElement(By.id("t2")).sendKeys("d");
        Thread.sleep(2000);
        driver.close();
    }
}
