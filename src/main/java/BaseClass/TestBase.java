package BaseClass;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import Utillities.TestBaseUtill;

public class TestBase {

	public static Properties prop;
	public static WebDriver driver;

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(
					"C:\\Selenium_Workspace\\AmazonCucumberPOM\\src\\main\\java\\Utillities\\config.properties");
			prop.load(ip);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void openBrowser()  {
		String browser = prop.getProperty("browser");
		System.out.println(browser);

		if (browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			System.setProperty("webdriver.edge.driver", "C:\\SeleniumJars\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		if (browser.equals("Safari")) {
			System.setProperty("webdriver.safari.driver", "C:\\SeleniumJars\\safaridriver.exe");
			driver = new SafariDriver();
		}
		
		PageFactory.initElements(driver, this);

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestBaseUtill.PAGE_LOAD_TIME_OUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestBaseUtill.IMPLICIT_WAIT));
		
		driver.get(prop.getProperty("url"));
	}
}
