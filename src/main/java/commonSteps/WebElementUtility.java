package commonSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;

public class WebElementUtility {

	/*
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

	/*
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

	/*
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
	
	/*
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

	/*
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

}
