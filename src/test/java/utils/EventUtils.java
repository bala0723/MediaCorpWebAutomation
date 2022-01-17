package utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EventUtils {
	
	RemoteWebDriver driver;
	public EventUtils(RemoteWebDriver driver) {
		this.driver=driver;
	}

	// To wait until element is clickable
		public boolean waitUntilElememtIsClickable(WebElement element, int timeOut) {
			boolean isElementEnabled;
			try {
				WebDriverWait wait = new WebDriverWait(driver, timeOut);
				wait.until(ExpectedConditions.elementToBeClickable(element));
				wait.pollingEvery(Duration.ofMillis(200));
				isElementEnabled = true;
			} catch (Exception e) {
//				e.printStackTrace();
				isElementEnabled = false;
			}
			return isElementEnabled;
		}

		// To wait until element is clickable
		public boolean waitUntilElememtIsClickable(By locator, int timeOut) {
			boolean isElementEnabled;
			try {
				WebDriverWait wait = new WebDriverWait(driver, timeOut);
				wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
				wait.pollingEvery(Duration.ofMillis(200));
				isElementEnabled = true;
			} catch (Exception e) {
				e.printStackTrace();
				isElementEnabled = false;
			}
			return isElementEnabled;
		}
	
	// To wait until element is present by Webelement
		public boolean waitUntilElementIsPresent(WebElement element, int timeout) {
			boolean isElementPresent = false;
			try {
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.visibilityOf(element));
				wait.pollingEvery(Duration.ofMillis(200));
				isElementPresent = true;
			} catch (Exception e) {
				isElementPresent = false;
				e.printStackTrace();
			}
			return isElementPresent;
		}

		// To wait until element is present by locator
		public boolean waitUntilElementIsPresent(By locator, int timeout) {
			boolean isElementPresent = false;
			try {
				WebDriverWait wait = new WebDriverWait(driver, timeout);
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				wait.pollingEvery(Duration.ofMillis(200));
				isElementPresent = true;
			} catch (Exception e) {
				isElementPresent = false;
//				e.printStackTrace();
			}
			return isElementPresent;
		}
	
}
