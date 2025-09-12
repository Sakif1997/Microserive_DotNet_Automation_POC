package TestCases;

import DriverSetup.BrowserSetup;
import Utilities.LoginPage;
import org.testng.annotations.Test;

public class TestLogin extends BrowserSetup {
    LoginPage loginpage = new LoginPage();
    @Test(description ="Verify login Successful" )
    public void testLogin() throws InterruptedException {
        getDriver().get("http://localhost:5173/");
        loginpage.login("anik", "1234");
        Thread.sleep(2000);
    }
}
