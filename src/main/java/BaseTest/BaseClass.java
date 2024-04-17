package BaseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public	Properties properties;
	public WebDriver driver;
	@BeforeTest
	public void InshilizeDriver() throws IOException {
		properties= new Properties();
		FileInputStream fc= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		properties.load(fc);

		String browsername = properties.getProperty("browser");
		if (browsername.equalsIgnoreCase("chrome")) {
			
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();
			driver.get("https://automationexercise.com/login");

		}
	
		driver.get("https://automationexercise.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.manage().getCookies();

	}
	@AfterTest
	public void TerDown() {
		driver.quit();
	}


}

