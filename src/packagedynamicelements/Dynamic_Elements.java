package packagedynamicelements;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dynamic_Elements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//set path to chrome driver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\raman\\eclipse-workspace\\testerr\\HKAselenium_Dynamic_Elements_Automation\\resources\\chromedriver.exe");
		
		//initialize the chrome driver
		WebDriver driver = new ChromeDriver();
		
		try {
			
			//navigate tot he target webpage
			driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
			
			//maximize the window
			driver.manage().window().maximize();
			
			//initialize explicit wait
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
			
			//Locate and click the start button
			WebElement startButton = driver.findElement(By.id("start")).findElement(By.tagName("button"));
			startButton.click();
			
			//Wait for the dynamically loaded element to be visible
			WebElement dynamicText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish")));
			
			//Print the dynamically loaded text
			System.out.println("Dynamic Text: " + dynamicText.getText());
		}
		
		catch (Exception e)
		{
			System.out.println("An error occurred: " + e.getMessage());
		}
		finally
		{
			//ensure the browser closes properly
			driver.quit();
		}
		
	}

}
