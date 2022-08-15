package Libraries;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class genericLib {
	static WebDriver driver;
	static WebDriverWait wait;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		initialize();

	}

	public static void initialize() throws FileNotFoundException {

		// System.setProperty("webdriver.chrome.driver","//Users//reanthon//Documents//Browser
		// Driver//chromedriver");
		// configProperties.initializePropertyFile();
		/*
		 * if(configProperties.property.getProperty("BrowserType").equalsIgnoreCase(
		 * "GoogleChrome")) driver = new ChromeDriver(); else
		 * System.out.println("Please Check Browser Type");
		 */
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver, Duration.ofSeconds(300));
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get("https://www.google.co.in/");

	}

	public static void navigateTo() {
		System.out.println("navigateTo");
		// driver.get(configProperties.property.getProperty("EnvUrl"));
		System.out.println("navigateTo");
	}

	public static void navigateTo(String Url) {
		System.out.println("navigateTo");
		driver.get(Url);
		System.out.println("navigatedTo" + Url);
	}

	public static void WaitForElement(String xpath, int secs) {
		System.out.println("WaitForElement");
		wait = new WebDriverWait(driver, Duration.ofSeconds(secs));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		System.out.println("Exiting WaitForElement");
	}

	public static void hardAssert(String xpath, boolean condition) throws Exception {
		try {
			if (condition == true) {
				Assert.isTrue(true, xpath + "Element Found", (driver.findElement(By.xpath(xpath)).isDisplayed()));
				System.out.println(xpath + " Element Found");
			}
			if (condition == false) {
				// Assert.assertFalse(driver.findElement(By.xpath(xpath)).isDisplayed());
				Assert.isTrue(false, xpath + "Element Found", (driver.findElement(By.xpath(xpath)).isDisplayed()));
				System.out.println(xpath + " Element Not Found");
			}
			System.out.println("Exiting hardAssert");
		} catch (Exception e) {
			System.out.println("Exception" + e);
		}
	}

	public static void selectOneChoice(String xpath, String value) throws Exception {
		WaitForElement(xpath, 120);
		WebElement ele = driver.findElement(By.xpath(xpath));
		String node = ele.getAttribute("nodeName");
		if (node.equalsIgnoreCase("Select")) {
			System.out.println("Selecting Option from DropDown");
			Select Element = new Select(ele);
			Element.selectByVisibleText(value);
		} else {
			ele.click();
			WaitForElement("//*[.='" + value + "']", 120);
			driver.findElement(By.xpath("//*[.='" + value + "']")).click();
		}
		System.out.println("Element Selected" + value);
	}

	public static void check(String xpath) throws Exception {
		WaitForElement(xpath, 120);
		WebElement ele = driver.findElement(By.xpath(xpath));
		boolean check = ele.isSelected();
		System.out.println("Check->" + check);
		if (check) {
			System.out.println("Element is already checked");
			return;
		} else
			ele.click();
		System.out.println("Element is checked");
	}

	public static void moveElement(String xpath1, String xpath2, ChromeDriver driver) throws Exception {
		Actions actions = new Actions(driver);
		WaitForElement(xpath1, 120);
		WebElement A = driver.findElement(By.xpath(xpath1));
		WebElement B = driver.findElement(By.xpath(xpath2));
		new Actions(driver).dragAndDrop(A, B).release().build().perform();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ESCAPE);
		robot.keyRelease(KeyEvent.VK_ESCAPE);
	}

	public static void slider(String xpath, String direction) throws InterruptedException {
		WebElement slider = driver.findElement(By.xpath(xpath));
		String dir[] = direction.split(";");
		for (String str : dir) {
			if (str.equalsIgnoreCase("Right"))
				slider.sendKeys(Keys.ARROW_RIGHT);
			else
				slider.sendKeys(Keys.ARROW_LEFT);
			Thread.sleep(3000);
		}

		System.out.println("Element Slided");
	}

	public static void switchToWindow(int index) throws InterruptedException {
		// String winHandleBefore = driver.getWindowHandle();
		int i = 0;
		for (String winHandle : driver.getWindowHandles()) {
			if (i == index) {
				driver.switchTo().window(winHandle);
				break;
			}
			i++;
		}
		System.out.println("Switched to window" + index);
	}

	public static void assertTable(String uniqueColumn, String matchingColumn, String Value) {
		List<WebElement> columnElements = driver
				.findElements(By.xpath("//th[.='" + uniqueColumn + "']/ancestor::table[1]//th"));
		int index = 0;
		int colIndex = 0;
		for (WebElement ele : columnElements) {
			System.out.println("Ele->" + ele.getText());
			index++;
			if (matchingColumn.equalsIgnoreCase(ele.getText())) {
				System.out.println("Index of Column Found" + index);
				break;
			}
		}
		WebElement table = driver.findElement(By.xpath("//th[.='" + uniqueColumn + "']/ancestor::table[1]//tbody"));
		List<WebElement> tableRows = table.findElements(By.tagName("tr"));
		Outer: for (int i = 0; i < tableRows.size(); i++) {
			System.out.println("Row->" + tableRows.get(i).getText());
			List<WebElement> row = tableRows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < row.size(); j++) {
				System.out.println("Td->" + row.get(j).getText());
				colIndex++;
				if (Value.equalsIgnoreCase(row.get(j).getText())) {
					System.out.println("ColIndex->" + colIndex + "Index" + index);
					System.out.println("####Matched#####" + index);
					break Outer;
				}
			}
			colIndex = 0;

		}
		if (colIndex == index) {
			System.out.println("Column" + matchingColumn + " has value" + Value);
		} else {
			System.out.println("#########Failed#########");
		}
	}

	public static void MouseClick(String xpath, String action) {
		WaitForElement(xpath, 120);
		Actions a = new Actions(driver);
		WebElement ele = driver.findElement(By.xpath(xpath));
		if (action.equalsIgnoreCase("ContextClick")) {
			a.moveToElement(ele).contextClick().build().perform();
		}
		System.out.println("Mouse " + action + " Performed");
	}
	public static void Click(String xpath) {
		WebElement ele = driver.findElement(By.xpath(xpath));
		if(ele!=null) {
			ele.click();
			System.out.println("Clicked");
		}
		else
			System.out.println("Element not Found"+xpath);
		
	}
	public static void quit() {
		System.out.println("!!!!!End Of Case!!!!!");
		driver.close();
		driver.quit();
		
	}

}