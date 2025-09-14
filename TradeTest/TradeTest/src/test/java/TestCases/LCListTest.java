package TestCases;

import DriverSetup.BrowserSetup;
import Utilities.LClistPage;
import Utilities.LoginPage;
import Utilities.Methods;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LCListTest extends BrowserSetup {
    Methods methods = new Methods();
    LoginPage loginpage = new LoginPage();

    public By dashbord = By.linkText(("Dashboard"));
    public By logout = By.xpath("//button[@title='Logout']");
    LClistPage lcListPage = new LClistPage();
    @Test (description ="Verify LC List page contents")
    public void lcListPageOperation() throws InterruptedException{
//        getDriver().get("http://localhost:5173/");
//        loginpage.login("anik", "1234");
//        Thread.sleep(2000);
//
        lcListPage.LCListPage();
        methods.clickElement(dashbord);
        Thread.sleep(2000);
        methods.clickElement(logout);

    }
}
