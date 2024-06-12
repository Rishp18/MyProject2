package TestCase;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.math3.ode.SecondaryEquations;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VideozenLogin {

	public static void main(String[] args) throws Exception {



		WebDriver driver=new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		String perent = driver.getWindowHandle();
		System.out.println("perent is  "+ perent );

		driver.findElement(By.id("openwindow")).click();

		Set<String> childs = driver.getWindowHandles();
		Iterator<String> it = childs.iterator();
		String fristst = it.next();
		System.out.println("frist child is  "+childs);
		String SecondaryE = it.next();
		System.out.println("second child is  "+SecondaryE);

		driver.switchTo().window(SecondaryE);
		WebElement B = driver.findElement(By.xpath("//a[text()='Access all our Courses']"));
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(B));
		B.click();
		Thread.sleep(3000);

		driver.quit();



	}

}
