package sel;
import Libraries.genericLib;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class test1 {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		//WebDriver driver = new ChromeDriver();
		//driver.get("https://www.google.com");
		genericLib.initialize();
		genericLib.navigateTo("https://www.google.co.in");
		genericLib.Click("(//input[@aria-label='Google Search'])[2]");
		System.out.print("Basic Frame Work Check Completed");
		genericLib.quit();
	}

}