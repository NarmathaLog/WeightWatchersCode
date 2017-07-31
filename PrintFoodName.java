import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

//Logic for Question2 
public class PrintFoodName {
	public WebDriver driver;
	String Url = "Your Url";
	String thirdItem ="";
	String fifthItem ="";

	@BeforeClass
	public void init() {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") + "/driver/chromedriver.exe");//Assuming Folder for Chromedriver.exe is in the project level 
		ChromeOptions option = new ChromeOptions();
		option.addArguments("start-maximized");
		driver = new ChromeDriver(option);
		driver.get(Url);
	}
	
	//Logic for Question2a
	@Test
	public void displayItems()
	{
		try {
			List<WebElement> foodName = driver.findElements(By.xpath("//div[@class='itemContent']//span[@class='title ng-binding']"));
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.visibilityOfAllElements(foodName));
			
			for (int i = 0; i < foodName.size(); i++) {
			           thirdItem = foodName.get(2).getText();
				       fifthItem = foodName.get(5).getText();
				}
			System.out.println("Third Item Name is: +thirdItem");
			System.out.println("Fifth Item Name is: +fifthItem");
		} catch (Exception e) {
			// we can print the customized error messages, if required.
			e.printStackTrace();
		}
		
	}

	//Logic for Question2b
	@Test
	public void displayItemsMap() throws InterruptedException 
	{
		try {
			List<WebElement> foodName = driver.findElements(By.xpath("//div[@class='itemContent']//span[@class='title ng-binding']"));
			List<WebElement> servings = driver.findElements(By.xpath("//div[@class='itemContent']//span[@class='description ng-binding']"));
			WebDriverWait wait = new WebDriverWait(driver, 2000);
			wait.until(ExpectedConditions.visibilityOfAllElements(foodName));

			HashMap<String, String> key = new HashMap<String, String>();
			System.out.println(foodName.size());
			for (int i = 0; i < foodName.size(); i++) {
				String keyValue = foodName.get(i).getText();
				String KeyPair = servings.get(i).getText();			
				key.put(keyValue, KeyPair);
			}
			System.out.println(key);
		} catch (Exception e) {
			// we can print the customized error messages, if required.
			e.printStackTrace();
		}
	}
	
	@AfterClass
	public void closeBrowser()
	{
		driver.quit();
	}
}
