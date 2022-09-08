import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Set;

public class Child_Browser_Popup {
    public static WebDriver driver;

    @BeforeTest
    public void launchbrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void print_window_Handle() {
        driver.get("https://www.naukri.com/");
        String windowHandle = driver.getWindowHandle();
        System.out.println("id of the browser: " + windowHandle);
    }

    @Test
    public void print_ChildBrowser_PopUp() {
        driver.get("https://www.naukri.com/");
        // using getWindowHandles(), get a set of window handle IDs
        Set<String> allWindowHandles = driver.getWindowHandles();
        // using size(), get the count of total number of browser windows
        int count = allWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : " + count);
        for (String windowHandle : allWindowHandles) {
            // switch to each browser window
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
            // print the window handle id of each browser window
            System.out.println("Window handle id of page -->" + title + " --> is : " + windowHandle);
            // close all the browsers one by one
            driver.close();
        }
    }

    @Test
    public void print_Close_MainBrowser_Only() {
        driver.get("https://www.naukri.com/");
        // get the window handle id of the parent browser window
        String parentWindowhandleID = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        int count = allWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : " + count);
        for (String windowHandle : allWindowHandles) {
            // switch to each browser window
            driver.switchTo().window(windowHandle);
            /*
             * compare the window id with the Parent browser window id, if both are equal,
             * then only close the main browser window.
             */
            if (windowHandle.equals(parentWindowhandleID)) {
                driver.close();
                System.out.println("Main Browser window with title -->" + " is closed");
            }
        }

    }

    @Test
    public void close_All_ChildBrowsers_Only() {
        driver.get("https://www.naukri.com/");
        // get the window handle id of the parent browser window
        String parentWindowhandleID = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();
        int count = allWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : " + count);
        for (String windowHandle : allWindowHandles) {
            // switch to each browser window
            driver.switchTo().window(windowHandle);
            String title = driver.getTitle();
            /*
             * compare the window id of all the browsers with the Parent browser window id,
             * if it is not equal, then only close the browser windows.
             */
            if (!windowHandle.equals(parentWindowhandleID)) {
                driver.close();
                System.out.println("Child Browser window with title -->" + title + " --> is closed");
            }
        }
    }

    @Test
    public void close_Any_SpecifiedBrowser() {
        driver.get("https://www.naukri.com/");
        //Set the expected title of the browser window which you want to close
        String expected_title = "Tech Mahindra";
        Set<String> allWindowHandles = driver.getWindowHandles();
        int count = allWindowHandles.size();
        System.out.println("Number of browser windows opened on the system is : "+ count);
        for (String windowHandle : allWindowHandles) {
            //switch to each browser window
            driver.switchTo().window(windowHandle);
        }
        String actual_title = driver.getTitle();
        //Checks whether the actual title contains the specified expected title
        if (actual_title.contains(expected_title)) {
            driver.close();
            System.out.println("Specified Browser window with title -->"+ actual_title +" --> is closed");
        }
    }

    @Test
    public void handleTabs_using_getWindowHandles() {
        //enter actitime login url
        driver.get("https://demo.actitime.com/login.do");
        //get the window handle id of the parent browser window
        String parentwindowHandle = driver.getWindowHandle();
        //enter username
        driver.findElement(By.id("username")).sendKeys("admin");
        //enter password
        driver.findElement(By.name("pwd")).sendKeys("manager");
        //click on actiTIME INC link
        driver.findElement(By.xpath("//a[normalize-space()='actiTIME Inc.']")).click();
        //get the number of windows currently opened on the system
        Set<String> allwhs = driver.getWindowHandles();
        //switch to all the browser windows
        for (String wh : allwhs) {
            driver.switchTo().window(wh);
        }
        //get the title of the tab
        String childtitle = driver.getTitle(); System.out.println("Title of the child tab is :"+ childtitle);
        //close the child tab
        driver.close();
        //switch back to the main browser window
        driver.switchTo().window(parentwindowHandle);
        driver.findElement(By.xpath("//div[text()='Login ']")).click();
        driver.close();
    }

}
