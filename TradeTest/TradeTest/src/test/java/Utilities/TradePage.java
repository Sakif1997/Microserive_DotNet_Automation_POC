package Utilities;

import org.openqa.selenium.By;

import java.time.LocalDateTime;

public class TradePage extends Methods{
    public By tradeDashbord= By.xpath("//h1[normalize-space()='Trade Finance Form']");
    public By BranchCode = By.name("branchCode");
    public By ProductCode = By.name("productCode");
    public By AccountNumber = By.name("accountNumber");
    public By CustomerCode = By.name("customerCode");
    public By CustomerLinkAccount = By.name("customerLinkAccount");
    public By TransactionDate = By.name("transactionDate");
    public By LCAmount = By.name("lcAmount");
    public By ImportDetails = By.name("importDetails");
    public By GoodsDetails = By.name("goodsDetails");
    public By ImportCondition = By.name("importCondition");
    public By CreatedBy = By.name("createBy");
    public By CreateDate = By.name("createDate");
    public By SaveButton = By.xpath("//button[normalize-space()='Submit']");

    public void TradeForm(String branchcode, String productcode, String customercode, String customerlinkaccount, String lcamount, String createdby) throws InterruptedException{
        WaitElementVisible(tradeDashbord);
        Thread.sleep(2000);
        FieldValue(BranchCode, branchcode);
        FieldValue(ProductCode, productcode);
        Thread.sleep(2000);
        //FieldValue(AccountNumber, accountnumber);


        selectByVisibleText(CustomerCode, customercode);

        takeScreenshot("Trade Finance form filled");
        Thread.sleep(3000);
        FieldValue(CustomerLinkAccount, customerlinkaccount);
        //FieldValue(TransactionDate, transactiondate);
        //FieldValueWithTime(TransactionDate,"12122025","1130");
        setDateTime(TransactionDate, LocalDateTime.of(2024, 12, 12, 11, 30));

        FieldValue(LCAmount, lcamount);
        Thread.sleep(3000);
        FieldValue(ImportDetails, "Three Container: Container number: C001, C002, C003");
        FieldValue(GoodsDetails, "Goods type: Electronics, Quantity: 500 units, Value: $100,000");
        Thread.sleep(2000);

        FieldValue(ImportCondition, "Goods will be shipped within 30 days. Payment to be made via Letter of Credit.");
        FieldValue(CreatedBy, createdby);
        takeScreenshot("Trade Finance number and details filled");
        Thread.sleep(3000);
        //FieldValue(CreateDate, createdate);
        //FieldValueWithTime(CreateDate,createdate,"1130");
        setDateTime(CreateDate, LocalDateTime.of(2025, 2, 20, 11, 30));
        takeScreenshot("Trade Finance form filled");
        Thread.sleep(3000);
        clickElement(SaveButton);
        takeScreenshot("Trade Finance form submitted");
        Thread.sleep(2000);
        popupaccept();
    }

}
