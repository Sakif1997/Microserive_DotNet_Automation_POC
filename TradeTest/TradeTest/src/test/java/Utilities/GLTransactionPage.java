package Utilities;

import org.openqa.selenium.By;

public class GLTransactionPage extends Methods {
    public By DashboardMenu = By.linkText("Dashboard");
    public By glTransactionMenu = By.linkText("GL Transaction");
    public By glTransactionPageHeader = By.xpath("//a[normalize-space()='GL Transaction']");
    public By valueDate = By.name("valueDate");
    public By currencyCode_select = By.name("currencyCode");
    public By voucherType_select = By.name("voucherType");
    public By DebitLeager_select = By.name("debitLedger");
    public By CreditLeager_select = By.name("creditLedger");
//    public By debitOperatingBalance = By.name("debitBalance");
//    public By creditOperatingBalance = By.name("creditBalance");
//    public By DebitCostCenter = By.name("debitCostCenter");
//    public By CreditCostCenter = By.name("creditCostCenter");
    public By DebitAmmount = By.name("debitAmount");
    public By CreditAmmount = By.name("creditAmount");
//    public By DebitAmmountInWords = By.name("debitWords");
//    public By CreditAmmountInWords = By.name("creditWords");
        public By debitNarration = By.name("debitNarration");
        public By creditNarration = By.name("creditNarration");
//    public By DebitEntryButton = By.xpath("//button[normalize-space()='Add debit Entry']");
//    public By CreditEntryButton = By.xpath("//button[normalize-space()='Add credit Entry']");
    public By submitButton = By.xpath("//button[normalize-space()='Submit']");

    public void GLTransactionForm(String Date, String currencycode, String vouchertype, String debitledger, String creditledger,  String debitamount, String creditamount, String debitnarration,String creditnarration) throws InterruptedException {
        Thread.sleep(4000);
        clickWaitElement(DashboardMenu);
        clickElement(glTransactionMenu);
        Thread.sleep(4000);

        WaitElementVisible(glTransactionPageHeader);
        takeScreenshot("GL Transaction Page");
        // Set Value Date to current date
        FieldValue(valueDate, Date);
        Thread.sleep(2000);

        selectByVisibleText(currencyCode_select, currencycode);
        Thread.sleep(2000);
        selectByVisibleText(voucherType_select, vouchertype);
        selectByVisibleText(DebitLeager_select, debitledger);
        selectByVisibleText(CreditLeager_select, creditledger);
//        FieldValue(debitOperatingBalance, debitbalance);
        takeScreenshot("GL Transaction form filled part 1");
        Thread.sleep(4000);
//        FieldValue(creditOperatingBalance, creditbalance);
//        clearfieldandInput(DebitCostCenter, debitcostcenter);
//        clearfieldandInput(CreditCostCenter, creditcostcenter);
        FieldValue(DebitAmmount, debitamount);
        FieldValue(CreditAmmount, creditamount);
        Thread.sleep(3000);
//        FieldValue(DebitAmmountInWords, debitamountinwords);
//        FieldValue(CreditAmmountInWords, creditamountinwords);
        FieldValue(debitNarration, debitnarration);
        FieldValue(creditNarration, creditnarration);
        takeScreenshot("GL Transaction form filled");
        Thread.sleep(2000);
//        clickElement(DebitEntryButton);
//        Thread.sleep(2000);
//        clickElement(CreditEntryButton);
        clickElement(submitButton);
        takeScreenshot("GL Transaction form submitted");
        Thread.sleep(2000);
        popupaccept();
    }
}
