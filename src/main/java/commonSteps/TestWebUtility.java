package commonSteps;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestWebUtility {

	WebDriver driver;
	@BeforeClass
	public void beforeClass()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	@Test
	public void test()
	{
		driver.get("https://www.opencart.com/");
		WebElementUtility.userScrollToGivenElement(driver, "//h5[contains(text(),'Support')]");
		//System.out.println(b);	
	}
	
	
	
}
