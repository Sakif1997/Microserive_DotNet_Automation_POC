package TestCases;

import DriverSetup.BrowserSetup;
import Utilities.TradePage;
import org.testng.annotations.Test;

public class TestTradeService extends BrowserSetup {
    TestLogin login = new TestLogin();
    TradePage tradepage = new TradePage();
    @Test(description = "Verify Trade Service form submission")
    public void testTradeService() throws InterruptedException {
        //login.testLogin();
        tradepage.TradeForm("BC001","PC001","Cus001","CUS0023","50000","Sakif Abdullah");
        Thread.sleep(2000);
    }

}
