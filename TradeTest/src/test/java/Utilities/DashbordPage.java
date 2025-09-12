package Utilities;

import org.openqa.selenium.By;

public class DashbordPage extends Methods {
	public By dashbord = By.xpath(("//h1[normalize-space()='Dashboard']"));
	public By Tradefinance_c = By.xpath("//h3[normalize-space()='Trade Finance']");
	public By TradeFinanceFormPage_w = By.xpath("//h1[normalize-space()='Trade Finance Form']");
	public By Reports_c = By.xpath("//h3[normalize-space()='Reports']");
	
	public void DashbordOperation() throws InterruptedException{
		WaitElementVisible(dashbord);
		Thread.sleep(3000);
		takeScreenshot("Dashbord");
		clickElement(Tradefinance_c);
		WaitElementVisible(TradeFinanceFormPage_w);
	}

}
