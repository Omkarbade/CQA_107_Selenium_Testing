import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Web_Table {
    public static WebDriver driver;

    @BeforeTest
    public void launchrowser() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void web_Table() {
        driver.get("C:\\Users\\OMKAR BADE\\Desktop\\Webtable.html");
        // Count Total number of rows present in the table
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();
        System.out.println("total number of rows present in the table is :" + totalRows);
        // count total number of columns
        List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
        int totalColumns = allColumns.size();
        System.out.println("Total number of columns in the table is :" + totalColumns);
        // Count number of cells present in the table
        List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        int totalCells = allCells.size();
        System.out.println("Total number of cells present in the table is :" + totalCells);
        // Print ONLY the numbers
        int countNumberValue = 0;
        int sum = 0;
        for (WebElement cell : allCells) {
            String cellValue = cell.getText();
            try {
                int number = Integer.parseInt(cellValue);
                System.out.print("" + number);
                countNumberValue++;
                sum = sum + number;
            } catch (Exception e) {

            }
        }
        System.out.println("Total count of numeric values is :" + countNumberValue);
        System.out.println("Total sum of all the numeric values is :" + sum);
        // close the browser
        driver.close();
    }

    @Test
    public void sum_Marks_Into_WebTable() {
        driver.get("C:\\Users\\OMKAR BADE\\Desktop\\Webtable.html");
        // Count Total number of rows present in the table
        List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
        int totalRows = allRows.size();
        System.out.println("total number of rows present in the table is : " + totalRows);
        // count total number of columns
        List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
        int totalColumns = allColumns.size();
        System.out.println("Total number of columns in the table is :" + totalColumns);
        // Count number of cells present in the table
        List<WebElement> allCells = driver.findElements(By.xpath("//th|//td"));
        int totalCells = allCells.size();
        System.out.println("Total number of cells present in the table is : " + totalCells);
        // Print ONLY the numbers
        int countNumberValue = 0;
        int sum = 0;
        for (WebElement cell : allCells) {
            String cellValue = cell.getText();
            try {
                int number = Integer.parseInt(cellValue);
                System.out.print(" " + number);
                countNumberValue++;
                sum = sum + number;
            } catch (Exception e) {

            }
        }
        System.out.println("Total count of numeric values is : " + countNumberValue);
        System.out.println("Total sum of all the numeric values is : " + sum);
        // close the browser
        // driver.close();
    }

    @Test
    public void auto_suggestion_Ex_GoogleSearch() throws InterruptedException {
        driver.get("http://www.google.com");
        // Enter Selenium in google search text box
        driver.findElement(By.xpath("//input[@aria-label='Search']")).sendKeys("selenium");

        Thread.sleep(2000);
        //List<WebElement> allOptions = driver.findElements(By.xpath("//h3[contains(text(),'Selenium')]"));
        List<WebElement> allOptions = driver.findElements(By.xpath("//*[contains(text(),'selenium')]"));
        int count = allOptions.size();
        System.out.println("Number of values present in the dropdown is : " + count);
        String expectedValue = "selenium interview questions";
        // Print all the auto suggestion values
        for (WebElement option : allOptions) {
            String text = option.getText();
            System.out.println(" " + text);
            // Click on Java Interview Questions
            if (text.equalsIgnoreCase(expectedValue)) {
                option.click();
            }
            break;
        }
    }

}
