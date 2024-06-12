package TestCase;

import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Brokenlinksa {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement broken : links) {

			String A = broken.getAttribute("href");

			verifylinks(A);
			driver.quit();
		}


	}
	public  static void verifylinks(String url) throws Exception {
		try {
			URL linksUrl=new URL(url);
			HttpsURLConnection httpsURLConnection=(HttpsURLConnection)linksUrl.openConnection();
			httpsURLConnection.setConnectTimeout(3000);
			httpsURLConnection.connect();

			if (httpsURLConnection.getResponseCode() == 200) {
				System.out.println(url + " - " + httpsURLConnection.getResponseMessage());
			} else {
				System.out.println(url + " - " + httpsURLConnection.getResponseMessage() + " - " + "is a broken link");
			}
		} catch (Exception e) {
			System.out.println(url + " - " + "is a broken link");
		}
	}
}
