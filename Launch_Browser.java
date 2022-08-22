import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Scanner;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Launch_Browser {

    public static void main(String[] args) {
        System.out.println("----Welcome for Selection of Web Browser----");
        Launch_Browser SelectBrowser = new Launch_Browser();
        int option;
        do {
            option = SelectBrowser.show();
            SelectBrowser.User(option);

        } while (option != 4);
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
                break;

            case 2:
                System.out.println("----Welcome to Fire Fox Web Browser----");
                System.setProperty("webdriver.gecko.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\geckodriver.exe");
                driver = new FirefoxDriver();
                driver.get("https://www.facebook.com/");
                driver.manage().window().maximize();
                break;

            case 3:
                System.out.println("----Welcome to Microsoft Edge Web Browser----");
                System.setProperty("webdriver.msedgedriver.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\msedgedriver.exe");
                driver = new EdgeDriver();
                driver.get("https://www.facebook.com/");
                driver.manage().window().maximize();
                break;

            case 4:
                System.out.println("Exit from Console");
                break;

            default:
                System.out.println("Choose Correct Option");
        }
    }
}
