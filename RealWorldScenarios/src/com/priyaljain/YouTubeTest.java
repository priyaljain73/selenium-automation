import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class YouTubeTest {
    WebElement element;
    WebDriver driver;

    //Member Functions
    @Before
    public void setUp() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Appium\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.youtube.com/watch?v=Vl24dP-HGOk");

    }

    @After
    public void tearDown() throws Exception {
        //new WebDriverWait(driver,10);
        Thread.sleep(5000);
        driver.quit();
    }

    @Test
    public void opensLipdubVideoAndChecksCount() throws Exception {

        System.out.println("Hello world");
        String Views = driver.findElement(By.xpath(".//*[@id='watch7-views-info']/div[1]")).getText();
        System.out.println("Views :"+Views);
    }

}