package commonSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

public class WebElementUtility {

	/*1
	 * Verifies that text of the field starts with given value
	 * 
	 */
	public static boolean verifyTextStartsWith(WebDriver driver, String xpath, String value) {
		boolean flag = false;
		String actualValue = null;
		try {
			actualValue = driver.findElement(By.xpath(xpath)).getText();
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}

		if (!actualValue.isEmpty()) {
			if (actualValue.startsWith(value)) {
				flag = true;
			}
		} else {
			System.out.println("String is blank");
		}

		return flag;
	}

	/*2
	 * Verifies that text of the field starts with given value
	 * 
	 */
	public static boolean verifyTextEndsWith(WebDriver driver, String xpath, String value) {
		boolean flag = false;
		String actualValue = null;
		try {
			actualValue = driver.findElement(By.xpath(xpath)).getText();
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}

		if (!actualValue.isEmpty()) {
			if (actualValue.endsWith(value)) {
				flag = true;
			}
		} else {
			System.out.println("String is blank");
		}

		return flag;
	}

	/*3
	 * Verifies that text of the field starts with given value
	 * 
	 */
	public static boolean verifyTextIsEqualTo(WebDriver driver, String xpath, String expectedValue) {
		boolean flag = false;
		String actualValue = null;
		try {
			actualValue = driver.findElement(By.xpath(xpath)).getText();
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		if (!actualValue.isEmpty()) {
			if (actualValue.equals(expectedValue)) {
				flag = true;
			}
		} else {
			System.out.println("String is blank");
		}

		return flag;
	}
	
	/*4
	 * Verifies that background color of the field is same is given color code
	 * 
	 */

	public static boolean verifyThatBackgroundColorOfFieldIs(WebDriver driver, String xpath, String ColorCode) {

		String backGroundColor = null;
		boolean flag = false;
		try {
			backGroundColor = driver.findElement(By.xpath(xpath)).getCssValue("background-color");
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		String hexaDecimalValue = Color.fromString(backGroundColor).asHex();
		if (!hexaDecimalValue.isEmpty()) {
			if (hexaDecimalValue.equals(ColorCode)) {
				flag = true;
			}
		} else {
			System.out.println("String is blank");
		}

		return flag;
	}

	/*5
	 * Verifies that color of the field is same is given color code
	 * 
	 */
	public static boolean verifyThatColorOfFieldIs(WebDriver driver, String xpath, String ColorCode) {

		String color = null;
		boolean flag = false;
		try {
			color = driver.findElement(By.xpath(xpath)).getCssValue("Color");
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		String hexaDecimalValue = Color.fromString(color).asHex();
		if (!hexaDecimalValue.isEmpty()) {
			if (hexaDecimalValue.equals(ColorCode)) {
				flag = true;
			}
		} else {
			System.out.println("String is blank");
		}

		return flag;
		
	}
	
	/*6
	 * User enters value in field
	 */

	public static void enterValueInField(WebDriver driver, String xpath,String value)
	{
		WebElement element=null;
		try {
			element= driver.findElement(By.xpath(xpath));
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		if(element.isEnabled())
		{
		element.sendKeys(value);
		}
		else
		{
			System.out.println("element is not enabled");
		}
	}
	
	/*7
	 *  user clears field , enters value and click
	 */
	public static void clearFieldAndEnterValue(WebDriver driver, String xpath,String value)
	{
		WebElement element=null;
		try {
			element.clear();
			element= driver.findElement(By.xpath(xpath));
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
		if(element.isEnabled())
		{
		element.sendKeys(value);
		}
		else
		{
			System.out.println("element is not enabled");
		}
	}
	
	/*8
	 * user move to element only
	 */
	public static void userMoveToElement(WebDriver driver, String xpath)
	{
		Actions action=new Actions(driver);
		try {
			action.moveToElement(driver.findElement(By.xpath(xpath))).perform();
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
	}
	
	/*9
	 * user move to element and click
	 * 
	 */
	public static void userMoveToElementAndClick(WebDriver driver, String xpath)
	{
		Actions action=new Actions(driver);
		try {
			action.moveToElement(driver.findElement(By.xpath(xpath))).click().perform();
		} catch (Exception e) {
			System.out.println("Exception is " + e);
		}
	}
	
	/*10
	 * Scroll tp given element
	 */
	public static void userScrollToGivenElement(WebDriver driver, String xpath)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		WebElement element=driver.findElement(By.xpath(xpath));
		js.executeScript("arguments[0].scrollIntoView()", element);
	}
	
}
