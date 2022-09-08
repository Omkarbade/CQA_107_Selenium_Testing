import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.Color;
import org.testng.annotations.Test;

public class Webelement_InterFace_Methods {
    @Test
    public void verifyFB_GetLocationMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement unTB = driver.findElement(By.id("email"));
        // get the y-coordinate of username field
        int username_Ycordinate = unTB.getLocation().getY();
        System.out.println(username_Ycordinate);
        WebElement pwdTB = driver.findElement(By.id("pass"));
        // get the y-coordinate of password field
        int password_Ycordinate = pwdTB.getLocation().getY();
        System.out.println(password_Ycordinate);
        // check whether the Y-coordinate of username and password field are same
        if (username_Ycordinate == password_Ycordinate) {
            System.out.println("Both username and password fields are displayed in the same row");
        } else {
            System.out.println("username and password fields are NOT aligned in the same row");
        }
    }


    @Test
    public void verifyFB_HeightAndWidth() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);

        WebElement unTB = driver.findElement(By.xpath("//input[@id='email'] "));
        // store the height of username
        int username_height = unTB.getSize().getHeight();
        // store the width of username
        int username_width = unTB.getSize().getWidth();
        System.out.println(username_height);
        System.out.println(username_width);

        WebElement pwdTB = driver.findElement(By.xpath("//input[contains(@name,'pass')]"));
        int passwordHeight = pwdTB.getSize().getHeight();
        int passwordWidth = pwdTB.getSize().getWidth();

        System.out.println(passwordHeight);
        System.out.println(passwordWidth);

        if (username_height == passwordHeight && username_width == passwordWidth) {
            System.out.println("Username and password fields are aligned");
        } else {
            System.out.println("Username and password fields are NOT aligned");

        }
    }
    @Test
    public void verifyFB_Usernamefield_lessthanMobileNumberField() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
            driver.get("https://www.facebook.com/");
            WebElement unTB = driver.findElement(By.id("email"));
            int username_width = unTB.getSize().getWidth();
            System.out.println(username_width);
//Identify the mobile number text box
            WebElement mobileNumTB = driver.findElement(By.xpath("//input[@id='email']"));
            int mobNumWidth = mobileNumTB.getSize().getWidth();
            System.out.println(mobNumWidth);
//Compare the width of both username and mobilenumber text box
            if (username_width==mobNumWidth) {
                System.out.println("Size of Both username and password fields are same" +username_width+" = " + mobNumWidth);
            }else{
                System.out.println("Size of username and password fields are NOT same that is : "
                        +username_width+" Not equals to " + mobNumWidth);
            }
        }
    @Test
    public void  Enter_Text_into_FocussedElement() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // entering text into the focussed element
        driver.switchTo().activeElement().sendKeys("admin");
    }

    @Test
    public void RemoveValuefromText_ClearMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mOmkar@gmail.com");
        Thread.sleep(2000);
        String value = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
        System.out.println("Value present inside the text box is : " + value);
        driver.findElement(By.xpath("//input[@type='text']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Omkar bade");
        Thread.sleep(2000);
//		 driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.CONTROL+"a"+Keys.DELETE);
//		 this line will actually delete the value if there is no space in the text entered
//		 if there is a space between two words in the username field, we have to use the below lines of code

//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.CONTROL + "a");
//        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.DELETE);
//        Thread.sleep(2000);
    }
    @Test
    public void RemoveValuefromText_withoutClearMethod() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Omkar    tt");
        Thread.sleep(2000);
        String value = driver.findElement(By.xpath("//input[@type='text']")).getAttribute("value");
        System.out.println("Value present inside the text box is : " + value);
//        driver.findElement(By.xpath("//input[@type='text']")).clear();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Omkar       Bade");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Keys.CONTROL + "a" + Keys.DELETE);
        Thread.sleep(2000);
    }
    @Test
    public void checkbox_present_ToolTip() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.actitime.com/login.do");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement Checkbox = driver.findElement(By.xpath("//label[@id='keepLoggedInLabel']"));
        // get the tooltip text using getAttribute() method and store in a variable
        String tooltipText = Checkbox.getAttribute("title");
        System.out.println(tooltipText);
        // driver.close();
    }
    @Test
    public void IsSelected_Test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://selenium08.blogspot.com/2019/07/check-box-and-radio-buttons.html");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement KeepMeLogIN_Checkbox = driver
                .findElement(By.xpath("//input[@name='color' and @value='blue']"));
        KeepMeLogIN_Checkbox.click();
        if (KeepMeLogIN_Checkbox.isSelected()) {
            System.out.println("Checkbox is selected");
        } else {
            System.out.println("Checkbox is NOT selected");
        }
    }
    @Test
    public void IsEnable_Test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        WebElement Username = driver.findElement(By.xpath("//input[@type='text']"));
        if (Username.isEnabled()) {
            System.out.println("Username text box is enabled");
        } else {
            System.out.println("Username text box is disabled");
        }
       // driver.close();
    }
    @Test
    public void GetAttribute() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String Fieldtype = driver.findElement(By.id("email")).getAttribute("name");

        System.out.println(Fieldtype);
        if (Fieldtype.equalsIgnoreCase("email")) {
            System.out.println("it is a email");
        } else {
            System.out.println("it is NOT a email");
        }
        driver.close();
    }
    @Test
    public void GetTagName() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String tagName = driver.findElement(By.xpath("//input[@type='text']")).getTagName();
        if (tagName.equals("input")) {
            System.out.println("View LIcence is a link");
        } else {
            System.out.println("View LIcence is NOT a link");
        }
       // driver.close();
    }
    @Test
    public void GetText() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String gettext = driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).getText();
        System.out.println(gettext);
    }
    @Test
    public void Verify_GetCssValue() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        // click on Login button
        driver.findElement(By.xpath("//button[text()='Log In']")).click();
        // find the error message element
        WebElement errorMsg = driver.findElement(By.xpath("//div[@class='_9ay7']"));
        // get the text of the error message
        String errortext = errorMsg.getText();
        // print the error message
        System.out.println("error message is :" + errortext);
        // get the value of color and store in a variable
        String c = errorMsg.getCssValue("color");
        // convert the color from string type to hexa form
        String ColorasHex = Color.fromString(c).asHex();
        System.out.println("hexadecimal format : " + ColorasHex);
        if (ColorasHex.equals("#ce0100")) {
            System.out.println("Error message is in red color");
        } else {
            System.out.println("Error message is in red color");
        }
        // get the size of the font of error message
        String fontSize = errorMsg.getCssValue("font-size");
        // get the weight of the font of error message
        String fontWeight = errorMsg.getCssValue("font-weight");
        System.out.println("Size of the font is :" + fontSize);
        System.out.println("Weight of the font is :" + fontWeight);
        driver.close();

    }

    @Test
    public void Multi_waysof_Clicking_ona_Button() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\OMKAR BADE\\Favorites\\Downloads\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        String xp = "//button[@type='submit']";

        // 1. using click() method
       // driver.findElement(By.xpath(xp)).click();

        // 2. using sendkeys
        driver.findElement(By.xpath(xp)).sendKeys(Keys.ENTER);
        /*
         * 3. using submit() method this method will work only and only if if the
         * element has an attribute called type= 'submit'
         */
       // driver.findElement(By.xpath(xp)).submit();

    }

}
