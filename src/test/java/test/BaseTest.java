package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.UnexpectedException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static final String URL = "https://www.loc.gov/";
    protected WebDriverWait wait;
    WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(String browser) throws IOException {

        InputStream file = new FileInputStream("resources/config.properties");
        Properties properties = new Properties();
        properties.load(file);

        switch(browser) {
            case "chrome":
                System.setProperty(properties.getProperty("PROPERTY_CHROME"), properties.getProperty("PATH_CHROME"));
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty(properties.getProperty("PROPERTY_FIRE"), properties.getProperty("PATH_FIRE"));
                driver = new FirefoxDriver();
                break;
            case "edge":
                System.setProperty(properties.getProperty("PROPERTY_EDGE"), properties.getProperty("PATH_EDGE"));
                driver = new EdgeDriver();
                break;
            default:
                throw new UnexpectedException("the browser: " + browser + " is not an option");

        }

        wait = new WebDriverWait(driver, 10);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(URL);
        driver.manage().window().maximize();

    }

    @AfterClass
    public void tearDown(){
        driver.close();
    }
}
