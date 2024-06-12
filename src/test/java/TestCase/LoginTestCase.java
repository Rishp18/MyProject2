package TestCase;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import BaseTest.BaseClass;
import BaseTest.JsonDataReader;
import Pages.LoginPage;
import io.reactivex.rxjava3.functions.Action;

public class LoginTestCase extends BaseClass {


	@Test(dataProvider = "LoginData")
	public void Loginuser(HashMap<String, String> input) throws AWTException {
		
		Actions action=new Actions(driver);
Robot rb=new Robot();
rb.keyPress(KeyEvent.VK_CONTROL);

		LoginPage page= new LoginPage(driver);
		WebElement title = page.LoginUserusing_ValidEmail(input.get("Email"), input.get("Passwoard"));
		Assert.assertEquals(title, "Full-Fledged practice website for Automation Engineers");
		WebElement title1 = page.LoginUserusing_INvalidValidEmail(input.get("Email"), input.get("Passwoard"));
		String B = title1.getText();
		Assert.assertEquals(title1, true);

	}

	@DataProvider(name = "LoginData")
	public Object[][] getdata() throws Exception {

		List<HashMap<String, String>> dataHashMaps= JsonDataReader.getjsonData(System.getProperty
				("user.dir")+"\\src\\main\\resources\\Testdata\\logindata.json");
		return new Object[][] {{dataHashMaps.get(0)},{dataHashMaps.get(1)}};

	}

}
