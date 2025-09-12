package Utilities;

import org.openqa.selenium.By;
import Utilities.Methods;

public class LoginPage extends Methods {
	public By UserName_in = By.name("username");
	public By Password_in = By.name("password");
	public By login_B = By.xpath("//button[normalize-space()='Login']");
	//public By tradeDashbord= By.xpath("//h1[normalize-space()='Trade Finance Form']");


	public void login(String username,String password) throws InterruptedException{

		FieldValue(UserName_in, username);
		FieldValue(Password_in, password);
		takeScreenshot("Successfully logged in");
		clickElement(login_B);
		//takeScreenshot("Successfully logged in");
		Thread.sleep(2000);
		takeScreenshot("Successfully logged in");

		//WaitElementVisible(tradeDashbord);
		//takeScreenshot("Trade Finance Dashboard page");
		//isTitleMatched("Trade Finance");


	}

}
