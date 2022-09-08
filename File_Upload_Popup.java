import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

public class File_Upload_Popup {
    public static WebDriver driver;

    @BeforeClass
    public void launch() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void file_Upload() throws InterruptedException {
        driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");
        driver.manage().window().maximize();

        // Explicit wait
        WebElement checkElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@multiple='']")));

        driver.findElement(By.xpath("//input[@multiple='']"))
                .sendKeys("C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\TripDetails.xls");
         driver.findElement(By.xpath("//button[@ng-click=\"uploader.uploadAll()\"]")).click();

    }
    @Test
    public void autoIt_UploadFile() throws InterruptedException, IOException {
        driver.get("https://www.freepdfconvert.com/pdf-to-word");
        driver.manage().window().maximize();
        // Explicit waits
        WebElement checkElement = new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Choose PDF file")));

        driver.findElement(By.linkText("Choose PDF file")).click();

        Runtime.getRuntime().exec("C:\\Users\\OMKAR BADE\\Documents\\File_Upload.exe");
    }
    @Test
    public void cancelOnPrintWindowPopup() throws InterruptedException, AWTException, IOException {
        driver.get("https://demo.actitime.com/login.do");
        Thread.sleep(3000);
        //Press Control + P from keyboard using Robot class
        Robot r = new Robot();
        r.keyPress(KeyEvent.VK_CONTROL);
        r.keyPress(KeyEvent.VK_P);
        r.keyRelease(KeyEvent.VK_P);
        r.keyRelease(KeyEvent.VK_CONTROL);
        //Using Runtime class, to run the .exe file
        Runtime run = Runtime.getRuntime();
        run.exec("C:\\Users\\OMKAR BADE\\Desktop\\Upload_File.exe");
        driver.close();
    }
}
