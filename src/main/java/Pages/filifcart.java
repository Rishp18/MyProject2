package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

public class filifcart {
	public static void main(String[] args) {


		WebDriver driver=new ChromeDriver();
		driver.get("https://www.google.com/search?gs_ssp=eJzj4tLP1TdILkqpqihQYDRgdGDw4kjLySzITiwqAQBm2Afs&q=flipkart&oq=filfcart&gs_lcrp=EgZjaHJvbWUqFQgCEC4YChiDARjHARixAxjRAxiABDIGCAAQRRg5MgYIARBFGEAyFQgCEC4YChiDARjHARixAxjRAxiABDIPCAMQABgKGIMBGLEDGIAEMg8IBBAAGAoYgwEYsQMYgAQyDwgFEAAYChiDARixAxiABDIMCAYQABgKGLEDGIAEMg8IBxAAGAoYgwEYsQMYgATSAQk2ODc2ajBqMTWoAgiwAgE&sourceid=chrome&ie=UTF-8");

		List<WebElement>	A=	driver.findElements(By.xpath("//a[text()='Subsidiaries']/../following-sibling::span//a"));
		String frist = A.get(1).getText();
		String frist4=A.get(2).getText();
		String frist1=A.get(3).getText();
		String frist2=A.get(0).getText();
		System.out.println(frist +frist4 + frist1 + frist2 );
		
		driver.switchTo().alert().accept();
	}



}
