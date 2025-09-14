package Utilities;

import static DriverSetup.BrowserSetup.getDriver;

import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.qameta.allure.Allure;

public class Methods {
	public WebElement getElement(By locator) {
	//import static Wppool.AssignmentWP.BrowserSetup.getDriver;
	return getDriver().findElement(locator);//driver = getDriver();
	}
	public String getPageTitle() {
		return getDriver().getTitle();
	}

	//for click webelement
	public void clickElement(By locator) {
		getElement(locator).click();
	}
	
	//for giving text input
	public void FieldValue(By locator,String text)
	{

		getElement(locator).sendKeys(text);
	}
	
	//Explicit wait 
	public void WaitElementVisible(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	//get text for webelement
	public String getText(By locator) {
		WebElement element =getElement(locator);
		return element.getText();
		
	}
//	public void FieldValueWithTime(By locator, String date, String time) {
//		//WebElement element = getElement(locator);
//		//element.sendKeys(date);
//		FieldValue(locator, date);
//		Actions action = new Actions(getDriver());
//		action.sendKeys(Keys.ARROW_LEFT)
//				.sendKeys(time)
//				.sendKeys(Keys.chord(Keys.CONTROL, "a"))
//				.perform();
//	}

	public void setDateTime(By locator, LocalDateTime dt) {
		WebElement el = getElement(locator);

		// Decide if seconds are required/allowed based on the 'step' attribute.
		// Default for datetime-local is 60 (minute precision). If step != 60, include seconds.
		String step = el.getAttribute("step"); // may be null
		boolean includeSeconds = step != null && !step.isBlank() && !"60".equals(step.trim());

		String pattern = includeSeconds ? "yyyy-MM-dd'T'HH:mm:ss" : "yyyy-MM-dd'T'HH:mm";
		String value = dt.format(DateTimeFormatter.ofPattern(pattern));

		// Try sendKeys first
		try {
			el.click();
			// robust clear (works better than element.clear() on some HTML5 pickers)
			el.sendKeys(Keys.chord(Keys.CONTROL, "a")); // Cmd on macOS also works with CONTROL in Selenium
			el.sendKeys(Keys.DELETE);
			el.sendKeys(value);

			// Optional: verify it stuck; if not, fall back to JS
			if (!value.equals(el.getAttribute("value"))) {
				throw new RuntimeException("Value not applied via sendKeys");
			}
		} catch (Exception e) {
			// Fallback: set via JS (very reliable with HTML5 date/time inputs)
			JavascriptExecutor js = (JavascriptExecutor) getDriver();
			js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input')); arguments[0].dispatchEvent(new Event('change'));", el, value);
		}
	}

	public void clickWaitElement(By locator) {
		WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
		WebElement waitelement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		waitelement.click();
	}
	public void CurrentPagetitleMatch(String title) {
		String currentTitle = getDriver().getTitle();
		if (currentTitle.equals(title)) {
			System.out.println("Current page title matches: " + currentTitle);
		} else {
			System.out.println("Current page title does not match. Expected: " + title + ", but got: " + currentTitle);
		}
	}
	public boolean isTitleMatched(String expectedTitle) {

		return getDriver().getTitle().equals(expectedTitle);
	}
	public void HoverAndClick(By locator) {
	    Actions action = new Actions(getDriver());
	    action.moveToElement(getElement(locator)).click().perform();
	}
	public void takeScreenshot(String name) {
		Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.BYTES)));
	}
	public void selectByVisibleText(By locator, String menuItem) {
		WebElement dropdown = getElement(locator);
		dropdown.click();
		Select select = new Select(dropdown);
		select.selectByVisibleText(menuItem);
	}
	public void clearfieldandInput(By locator, String text) {
		getDriver().findElement(locator).sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
		getDriver().findElement(locator).sendKeys(text);
	}
	public void popupaccept(){
		Alert alert = getDriver().switchTo().alert();
		alert.accept();
	}
	

}
