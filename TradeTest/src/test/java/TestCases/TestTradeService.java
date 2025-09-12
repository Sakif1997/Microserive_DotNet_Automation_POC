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
        tradepage.TradeForm("DH001", "SPRAY002", "12121121", "654321", "100000","1000","Sakif Abdullah");
        Thread.sleep(2000);
    }

}
