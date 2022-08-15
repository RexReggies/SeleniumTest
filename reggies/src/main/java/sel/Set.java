package sel;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class Set {

	public static void main(String[] args) throws InterruptedException {
		String xpath = null;
		System.out.print("Test cases started" + "\n");
		System.setProperty("webdriver.chrome.driver","/Users/psinghpa/Desktop/Sel/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		naviGate(driver, "https://www.amazon.in/", "M");
		
		xpath = "//input[contains(@id,'twotabsearchtextbox')]";
		inputBox(driver, xpath, "Samsung Galaxy S20 FE 5G");
		
		
		clickByPartialLinkText(driver, "Samsung Galaxy S20 FE 5G");
				
		winHandle(driver);
		
		clickByXpath(driver, "//*[@id=\"submit.add-to-cart\"]");

		implicitlyWait(driver,120,TimeUnit.SECONDS);
	
		driver.findElement(By.xpath("(//form[@id='attach-view-cart-button-form']/descendant::input)[1]")).click();
		
		
		clickCheckBoxByXpath(driver, "(//input[contains(@name,'isToBeGiftWrapped')])[1]");
		
		clickByXpath(driver, "//input[contains(@name,'proceedToRetailCheckout')]");
		
		winTabClose(driver);
		winBrClose(driver);
       
	}
	
	private static void winTabClose(WebDriver driver) {
		driver.close();
		String str = winHandle(driver);
		System.out.print("Report : Method -> winTabClose : Closing the current tab : " + str + "\n");
	}

	private static void winBrClose(WebDriver driver) {
		driver.quit();
		System.out.print("Report : Method -> winBrClose : Closing the browser");
	}

	private static void implicitlyWait(WebDriver driver, int i, TimeUnit unit) {
		driver.manage().timeouts().implicitlyWait(i,unit);	
		System.out.print("Report : Method -> implicitlyWait : PASS : " + i + " " + unit + " \n");
	}


	public static void clickCheckBoxByXpath(WebDriver driver, String xpath) {
		WebElement element = driver.findElement(By.xpath(xpath));
		boolean check = element.isSelected();
		
		if(check == false)
		element.findElement(By.xpath(xpath)).click();
		else
		System.out.print("Report : Method -> clickCheckBoxByXpath : Check box was already Selected");
		
		System.out.print("Report : Method -> clickCheckBoxByXpath : PASS" + "\n");
		
	}

	public static String winHandle(WebDriver driver) 
	{ int i =0;
	  String winCount = null;
	  for(String winHandle : driver.getWindowHandles())
	     {
          	i++;
                 driver.switchTo().window(winHandle); 
                  if(i == 1)
                	  winCount = driver.getWindowHandle();
                  else
                  	break;
         } 
	  System.out.print("Report : Method -> winHandle: PASS : "+ winCount + "\n");
	  return winCount;
	}

	public static void clickByLinkText(WebDriver driver, String xpath)
	{
		driver.findElement(By.linkText(xpath)).click();;
		System.out.print("Report : Method -> clickBylinkText: PASS : " + xpath + "\n");
		
	}
	
	public static void clickByPartialLinkText(WebDriver driver, String xpath)
	{
		driver.findElement(By.partialLinkText(xpath)).click();;
		System.out.print("Report : Method -> clickBypartialLinkText: PASS : " + xpath + "\n");
	}	
	

	public static void clickByXpath(WebDriver driver, String xpath)
	{
		driver.findElement(By.xpath(xpath)).click();;
		System.out.print("Report : Method -> clickByXpath : PASS :" + "\n");
	}
	
	public static void inputBox(WebDriver driver, String xpath, String keywords)
	{
		WebElement element = driver.findElement(By.xpath(xpath));
		element.sendKeys(keywords);
		element.sendKeys(Keys.RETURN);	
		System.out.print("Report : Method -> inputBox: PASS : " + keywords + "\n");
	}
	
	public static void naviGate(WebDriver driver, String xpath)
	{
		driver.get(xpath);	
		System.out.print("Title :" + driver.getTitle() + "\n");
		System.out.print("Report : Method -> naviGate: PASS : "+ xpath + "\n");
	}
	
	public static void naviGate(WebDriver driver, String xpath, String key1)
	{
		driver.get(xpath);	
		driver.manage().window().maximize();
		System.out.print("Title  :" + driver.getTitle() + "\n");
		System.out.print("Report : Method -> naviGate: PASS : "+"In Maximize Mode : "+xpath + "\n");
	}

}
