package TestCases;

import DriverSetup.BrowserSetup;
import Utilities.GLTransactionPage;
import Utilities.LoginPage;
import org.testng.annotations.Test;

public class GLTransactionTest extends BrowserSetup {
    LoginPage loginpage = new LoginPage();
    GLTransactionPage gltran = new GLTransactionPage();

    @Test (description = "Verify GL Transaction form submission")
    public void testGLTransaction() throws InterruptedException {
//        getDriver().get("http://localhost:5173/");
//        loginpage.login("anik", "1234");
//        Thread.sleep(2000);
        //String currencycode, String vouchertype, String debitledger, String creditledger, String debitbalance, String creditbalance, String debitcostcenter, String creditcostcenter, String debitamount, String creditamount, String debitamountinwords, String creditamountinwords, String debitnarration, String creditnarration
        //gltran.GLTransactionForm("11012025", "Journal Voucher","Ledger 1", "Hasib Account", "Trade", "5000", "5000","","");

        gltran.GLTransactionForm("11012025", "BDT - Bangladeshi Taka","Journal Voucher", "Hasib Account", "Trade", "5000","5000", "Test debit narration","Test credit narration");
        Thread.sleep(2000);
    }
}
