package srvanthi_testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverCommands {
	String Buildpath="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	//@Parameters ({"admin","admin123"})
	
@Test(enabled=true,priority=-1,groups="BrowserCommands")
public void TC1() throws InterruptedException,AssertionError  {
	System.setProperty("webdriver.chrome.driver", "D:\\Selinium Web Driver\\drivers\\chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	//WebDriver driver1=new ChromeDriver();
	Thread.sleep(3000);
	//driver1.get("https://www.javatpoint.com/selenium-webdriver-commands");
	//driver.get("https://www.javatpoint.com/selenium-webdriver-commands");
	driver.get(Buildpath);
	WebElement userid=driver.findElement(By. xpath("//input[@name='txtUsername']"));
	WebElement passwd=driver.findElement(By.xpath("//input[@name='txtPassword']"));
	WebElement login=driver.findElement(By.xpath("//input[@value='LOGIN']"));
		//WebElement commands
	userid.sendKeys("Admin");
	passwd.sendKeys("admin123");
	login.click();
	String titl=driver.getTitle();
	Assert.assertEquals(titl,"OrangeHRM");
	Thread.sleep(1000);
	/*	userid.clear();
	userid.click();
	//browser commands 
	int hl=driver.findElements(By.xpath("//a")).size();
	System.out.println(hl);
	driver.get("https://www.javatpoint.com/selenium-webdriver-commands");
	driver.navigate().back();
	driver.navigate().forward();
	driver.navigate().refresh();
	driver.getTitle();
	driver.toString();
	//
	//driver.quit();
	//moving between windows
	driver.switchTo().window("OrangeHRM");
	//moving between frames
	driver.switchTo().frame(0);*/
	Thread.sleep(5000);
	Actions act=new Actions(driver);
	WebElement Admn=driver.findElement(By.xpath("//b[contains(text(),'Admin')]"));
	act.moveToElement(Admn).perform();
	WebElement usermanagement =driver.findElement(By.xpath("//a[@id='menu_admin_UserManagement']"));
	act.moveToElement(usermanagement).perform();
	Thread.sleep(5000);
	 driver.findElement(By.xpath("//a[@id='menu_admin_viewSystemUsers']")).click();;
	Thread.sleep(5000);
	//act.moveToElement(users).perform();
	Thread.sleep(5000);
	String sysusers=driver.findElement(By.xpath("//a[contains(text(),'>')]")).getText();
	Assert.assertEquals(sysusers ,">" );
    //act.keyDown(Keys.CONTROL).sendKeys("n").keyUp(Keys.CONTROL).build().perform();
   // driver.get("http://www.gmail.com");
  //driver.navigate().back();
 // driver.quit();
    //driver.switchTo().window("Selenium WebDriver Commands - javatpoint");
	//handling wth dropdown and using collection ie List
	Select  sl=new Select(driver.findElement(By.id("searchSystemUser_userType")));
	List<WebElement> links=driver.findElements(By.xpath("//a"));
	int linkn=links.size();
	List<WebElement> lst=sl.getOptions();
	int lstn=lst.size();
	for(int i=0;i<lstn;i++) {
		String display=lst.get(i).getText();
		sl.selectByIndex(0);
		System.out.println(display);
	}
	for(int i=0;i<linkn;i++) {
		String displaylink=links.get(i).getText();
		System.out.println(displaylink);
	}
	//inorder to scroll the	 a web page we need to use javascript executer class and scrollby()/scrollIntoView() etc
	JavascriptExecutor  js=(JavascriptExecutor)driver;
    js.executeScript("window.scrollBy(0,1000)");
    

	}

}
