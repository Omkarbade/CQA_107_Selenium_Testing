import org.testng.Reporter;
import org.testng.annotations.*;
@Test
public class Testng {
    @BeforeMethod
    public void beforeMethod() {
        Reporter.log("beforeMethod", true);
    }
    @AfterMethod
    public void afterMethod() {
        Reporter.log("afterMethod", true);
    }
    @BeforeClass
    public void beforeClass() {
        Reporter.log("beforeClass", true);
    }
    @AfterClass
    public void afterClass() {
        Reporter.log("afterClass", true);
    }
    @BeforeTest
    public void beforeTest() {
        Reporter.log("beforeTest", true);
    }
    @AfterTest
    public void afterTest() {
        Reporter.log("afterTest", true);
    }
    @BeforeSuite
    public void beforeSuite() {
        Reporter.log("beforeSuite", true);
    }
    @AfterSuite
    public void afterSuite() {
        Reporter.log("afterSuite", true);
    }
}
