package TestCases;

import org.testng.annotations.Test;

import DriverSetup.BrowserSetup;
import Utilities.DashbordPage;

public class Dashbordtest extends BrowserSetup {
	DashbordPage dbPage = new DashbordPage();
	
	
	@Test(description ="Verify dashbord page contents")
	public void dashbordOperation() throws InterruptedException{
		dbPage.DashbordOperation();
	}
	

}
