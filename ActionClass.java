import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ActionClass {
    public static WebDriver driver;

    @BeforeTest
    public void launchbrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();

    }

    @Test
    public void contextClick_using_ActionsClass() throws InterruptedException, AWTException {
        driver.get("https://demo.actitime.com/login.do");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement link = driver.findElement(By.xpath("//a[text()='actiTIME Inc.']"));

        // right click (context click) on actitime link
        Actions actions = new Actions(driver);
        actions.contextClick(link).perform();
        Thread.sleep(3000);

        // press 'w' from the keyboard for opening in a new window
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_W);
        robot.keyRelease(KeyEvent.VK_W);
        // quit() method closes all the browsers opened by Selenium
        //driver.quit();
    }

    @Test
    public void gmail_contextClickDemo_mailArchive() throws InterruptedException {
        driver.get("https://www.gmail.com/");
        // enter email id
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("omiii987654321@gmail.com");
        // click on Next button
        driver.findElement(By.xpath("//span[.='Next']")).click();
        Thread.sleep(3000);
        // enter password id
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("8983323680");
        // click on Next button
        driver.findElement(By.xpath("//span[.='Next']")).click();
        Thread.sleep(2000);

        // Write xpath expression for the mail item based on a subject
        String xp = "(//div[contains(@role,'checkbox')])[2]";


        // get the address of the mail item which you want to archive
        WebElement mail = driver.findElement(By.xpath(xp));

        // print the subject of the mail
        System.out.println(mail.getText());

        // Creating an object of Actions class
        Actions actions = new Actions(driver);

        // using Actions class object and contextClick() method, right click on the mail
        // item
        actions.contextClick(mail).perform();
        Thread.sleep(6000);

        // click on Archive to archive the mail
        driver.findElement(By.xpath("(//div[@class='J-N-JX aDE aDD'])[1]")).click();

    }

    @Test
    public void moveToElement() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement element = driver.findElement(By.id("pass"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        Thread.sleep(2000);
    }

    @Test
    public void MouseHover() throws InterruptedException {
        driver.get("http://www.actimind.com/");
        driver.manage().window().maximize();
        Actions action = new Actions(driver);
        // movetoElement - used for mouse hover
        // Mouse hover on “AREAS OF EXPERTISE” menu
        WebElement AreaOfExpertise = driver.findElement(By.xpath("//a[contains(text(),'AREAS OF EXPERTISE')]"));
        action.moveToElement(AreaOfExpertise).perform();
        // Click on “AREAS OF EXPERTISE” menu
        WebElement cloudApp = driver.findElement(By.linkText("Cloud Applications"));
        action.moveToElement(cloudApp).click().perform();
        // composite multiple actions can be achieved using the below statement
        // action.moveToElement(AreaOfExpertise).moveToElement(cloudApp).click().build().perform();
    }

    @Test
    public void DropDownMenu() throws InterruptedException {
        driver.get("http://www.actimind.com/");
        driver.manage().window().maximize();
        // find the menu "Aera Expertise"
        String xp = "//a[@class='c-link dropdown-toggle']";
        WebElement menu = driver.findElement(By.xpath(xp));
        Actions actions = new Actions(driver);
        actions.moveToElement(menu).perform();
        // click on submenu "UI/UX Design"
        WebElement submenu = driver.findElement(By.linkText("UI/UX Design"));
        submenu.click();

    }

    @Test
    public void dragAndDrop() throws InterruptedException {
        driver.get("https://jqueryui.com/droppable/");
       // String xp1 = "//div[@id='draggable']";
        //WebElement block1 = driver.findElement(By.xpath(xp1));
        driver.switchTo().frame(0);
        WebElement element = driver.findElement(By.xpath("//div[@id='draggable']"));
        String xp2 = "//div[@id='droppable']";
        WebElement block2 = driver.findElement(By.xpath(xp2));
        Actions actions = new Actions(driver);
        // drag block 1 element and drop it on block 2 element
        actions.dragAndDrop(element, block2).perform();
    }
    @Test
    public void dragAndDropbyOffset() {
        driver.get("http://www.dhtmlgoodies.com/submitted-scripts/i-google-like-drag-drop/index.html");
        // write xpath for Block 1
        String xp1 = "//h1[.='Block 1']";
        WebElement block1 = driver.findElement(By.xpath(xp1));
        // write xpath for Block 3
        String xp2 = "//h1[.='Block 3']";
        WebElement block3 = driver.findElement(By.xpath(xp2));
        // Create an object of Actions class and pass driver object as an argument
        Actions actions = new Actions(driver);
        // call the dragAndDropBy() method of Actions class
        actions.dragAndDropBy(block1, block3.getLocation().getX() + 10, block3.getSize().getHeight() + 10).perform();
    }

    @Test
    public void key() throws InterruptedException {
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement searchElement = driver.findElement(By.xpath("//input[@name='q']"));
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).perform();
        Thread.sleep(2000);
        action.sendKeys("Zomato").perform();
        Thread.sleep(2000);
        action.keyUp(Keys.SHIFT).perform();
        Thread.sleep(2000);
        action.doubleClick(searchElement).perform();
        Thread.sleep(2000);
        action.keyDown(Keys.CONTROL).sendKeys("x").perform();
        Thread.sleep(2000);
        action.keyUp(Keys.CONTROL).perform();
        Thread.sleep(2000);
        action.keyDown(Keys.CONTROL).sendKeys("v").perform();
        Thread.sleep(2000);
        action.keyUp(Keys.CONTROL).perform();
    }
}
