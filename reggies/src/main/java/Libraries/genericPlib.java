package Libraries;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class genericPlib {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static void loginTo(ChromeDriver driver, String username, String pwd) {
		if (driver.getTitle().contains("Linked"))
			driver.findElement(
					By.cssSelector("a[aria-label$='Already have an account?'],a[class^=\"nav__button-secondary\"]"))
					.click();
		else
			System.out.print("Not Linked In");

		driver.findElement(By.cssSelector("input[id*='email'],[id='username']")).sendKeys(username);
		driver.findElement(By.cssSelector("input[id*='pass']")).sendKeys(pwd);
		driver.findElement(By.cssSelector("[type$=\"submit\"]")).click();

		System.out.print("Report : Method -> loginTo : " + driver.getTitle() + "\n");
	}

	public static void naviGate(WebDriver driver, String xpath) {
		driver.get(xpath);
		System.out.print("Report : Title  -> " + driver.getTitle() + "\n");
		System.out.print("Report : Method -> naviGate: PASS : " + xpath + "\n");
	}

	public static void naviGate(WebDriver driver, String xpath, String key1) {
		driver.get(xpath);
		driver.manage().window().maximize();
		System.out.print("Report : Title  -> " + driver.getTitle() + "\n");
		System.out.print("Report : Method -> naviGate: PASS : " + "In Maximize Mode : " + xpath + "\n");
	}

	public static void winTabClose(WebDriver driver) {
		String str = driver.getWindowHandle();
		driver.close();
		System.out.print("Report : Method -> winTabClose : Closing the current tab : " + str + "\n");
	}

	public static void winBrClose(WebDriver driver) {
		driver.quit();
		System.out.print("Report : Method -> winBrClose  : Closing the browser \n");
	}

	public static String winHandle(WebDriver driver) {
		int i = 0;
		String winCount = null;
		for (String winHandle : driver.getWindowHandles()) {
			i++;
			driver.switchTo().window(winHandle);
			if (i == 1)
				winCount = driver.getWindowHandle();
			else
				break;
		}
		System.out.print("Report : Method -> winHandle : PASS : " + winCount + "\n");
		return winCount;
	}

}
