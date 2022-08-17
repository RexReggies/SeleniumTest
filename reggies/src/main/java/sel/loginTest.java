package sel;

import Libraries.genericPlib;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {
		
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		String url = "https://www.linkedin.com/";
		//String url = "https://www.facebook.com/";
		String username = "username";
		String pwd = "password";
		
		genericPlib.naviGate(driver, url, "M");
		genericPlib.loginTo(driver, username, pwd);   //Currently Tested on Facebook and Linked In.
		//genericPlib.winHandle(driver);
	    genericPlib.winTabClose(driver);
		genericPlib.winBrClose(driver);
	}
	
}
