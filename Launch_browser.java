import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Launch_browser {

    public static void main(String[] args) {
        System.out.println("Welcome to Web Browser");
        Launch_browser SelectBrowser = new Launch_browser();
        int option;
        do{
            option = SelectBrowser.show();
            SelectBrowser.User(option);
        } while(option !=4 );
    }

    public int show() {
        System.out.println("Select any one Browser from below options \n1.Chrome Browser" +
                "\n2.firefox Browser\n" + "3. Edge Browser\n4. Exit");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();
        return option;
    }


    public void User(int option) {
        switch (option) {
            case 1:
                System.out.println("----Welcome to Chrome Web Browser----");
                System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");

                WebDriver driver = new ChromeDriver();
                driver.manage().window().maximize();
                driver.get("https://www.facebook.com/");
                driver.findElement(By.id("email")).sendKeys("Test123@gmail.com");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.findElement(By.name("pass")).sendKeys("Test@12345");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver.findElement(By.name("login")).click();

                break;

            case 2:
                System.out.println("----Welcome to Fire Fox Web Browser----");
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\geckodriver.exe");
                WebDriver driver1 = new FirefoxDriver();
                driver1.manage().window().maximize();
                driver1.get("https://www.facebook.com/");
                driver1.findElement(By.id("email")).sendKeys("Test123@gmail.com");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver1.findElement(By.name("pass")).sendKeys("Test@12345");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver1.findElement(By.name("login")).click();

                break;

            case 3:
                System.out.println("----Welcome to Microsoft Edge Web Browser----");
                System.setProperty("webdriver.msedgedriver.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\edgedriver_win64\\msedgedriver.exe");
                WebDriver driver2 = new EdgeDriver();
                driver2.manage().window().maximize();
                driver2.get("https://www.facebook.com/");
                driver2.findElement(By.id("email")).sendKeys("Test123@gmail.com");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver2.findElement(By.name("pass")).sendKeys("Test@12345");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                driver2.findElement(By.name("login")).click();

                break;

            case 4:
                System.out.println("Exit from Console");
                break;

            default:
                System.out.println("Choose Correct Option");
        }
    }
}
