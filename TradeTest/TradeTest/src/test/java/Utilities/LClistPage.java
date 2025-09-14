package Utilities;

import org.openqa.selenium.By;

public class LClistPage extends Methods{
    public By lCMenu= By.xpath("//a[normalize-space()='LC List']");
    public By lCListPageHeader= By.xpath("//h2[normalize-space()='Trade Finance Records']");

    public void LCListPage() throws InterruptedException{
        Thread.sleep(2000);
        clickElement(lCMenu);
        WaitElementVisible(lCListPageHeader);
        takeScreenshot("LC List page displayed");
        Thread.sleep(2000);
    }
}
