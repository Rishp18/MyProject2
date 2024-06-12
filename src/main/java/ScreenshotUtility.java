import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.github.dockerjava.api.model.Driver;

public class ScreenshotUtility {

	public	WebDriver driver;
	@Test
	public void ScreenShot() throws IOException {


		driver= new ChromeDriver();
		driver.get("https://github.com/");
		driver.manage().window().maximize();
		TakesScreenshot tcScreenshot= (TakesScreenshot)driver;
		File A = tcScreenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(A, new File("C:\\Users\\DELL\\OneDrive\\Pictures\\Screenshots\\github.png"));
		driver.quit();
	}
	@Test
	public void Scroll() throws Exception {
		WebDriver driver= new ChromeDriver();
		driver.get("https://web.whatsapp.com/");
		driver.manage().window().maximize();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scroll(0,700)");
		Thread.sleep(3000);
	}

}
