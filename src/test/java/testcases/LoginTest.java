package testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Pages.LoginPage;

public class LoginTest extends BaseClass {

	@Test
	public void test1() throws InterruptedException {
		LoginPage loginObj = new LoginPage(driver);
		loginObj.LoginFunction("abcd@xyz.com", "Abcd@12345");
		Thread.sleep(10000);
		WebElement error = driver.findElement(By.id("msg_box"));

		String ActError = error.getText();
		String ExpError = "The email or password you have entered is invalid.";

		Assert.assertEquals(ActError, ExpError);

	}

	@Test
	public void test2() {

		LoginPage loginObj = new LoginPage(driver);
		loginObj.LoginFunction("pqrs@xyz.com", "Abcd@12345");
	}

	@Test
	public void test4() throws FilloException, InterruptedException {
		
		Thread.sleep(10000);
		Recordset recordset = connection.executeQuery("select * from data where TestName='test4'");
		recordset.next();
			
		String UserName = recordset.getField("UserName");
		String Password = recordset.getField("Password");
		
		LoginPage loginObj = new LoginPage(driver);
		loginObj.LoginFunction(UserName, Password);

		
	}

}
