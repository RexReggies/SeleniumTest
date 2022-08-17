package sel;
import Libraries.genericLib;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {

	public static void main(String[] args) throws Exception {
	// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com");
		genericLib.initialize();
		genericLib.navigateTo("https://www.google.co.in");
		genericLib.set("css=input[title='Search']","Google");
		//genericLib.Click("css=span[class*=' MZy1Rb']>svg");
		genericLib.Click("(//input[@value='Google Search'])[2]");
		genericLib.WaitForElement("xpath=(//*[text()='Google'])[1]",5);
		genericLib.Click("xpath=(//*[text()='Google'][1])");
		genericLib.hardAssert("css=img[alt='Google']",true);
		genericLib.hardAssert("xpath=//img[@alt='Google']",true);
		//genericLib.hardAssert("xpath=//*[text()='Negative Check']",false);
		System.out.print("Basic Frame Work Check Completed");
		genericLib.quit();
	}

}