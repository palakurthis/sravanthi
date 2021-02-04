package srvanthi_testng;

import java.io.File;
import java.io.IOException;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class Locators {
	String Buildpath="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
	WebDriver driver;
		//@Parameters ({"admin","admin123"})
	@BeforeMethod(groups="login")
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selinium Web Driver\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
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
	}
	
	@Test(enabled=true)
	public void xpath() throws InterruptedException, AssertionError, IOException {
		//using locator as xpath and writing xpath in different ways
		WebElement time=driver.findElement(By.xpath("//a[@id='menu_time_viewTimeModule']"));
		Actions act=new Actions(driver);
		act.moveToElement(time).perform();
		Thread.sleep(1000);
		act.moveToElement(driver.findElement(By.xpath("//a[@id='menu_time_Reports']"))).perform();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@id='menu_time_displayProjectReportCriteria']")).click();	
		Thread.sleep(1000);
		//Assert.assertEquals(actual, expected);
		Select sl=new Select(driver.findElement(By.xpath("//Select[@name='time[project_name]']")));
		int to=sl.getOptions().size();
		//Select sl1=new Select(driver.findElement(By.xpath("//Select[@name='time[project_name]']")));
		for(int i=0;i<to;i++) {
			sl.selectByIndex(i);
			Thread.sleep(1000);
			
			Thread.sleep(1000);
			TakesScreenshot scrShot =(TakesScreenshot)driver;
			 File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
Files.copy(SrcFile, new File("D:\\Selinium Web Driver\\screenshots\\"+i+".png"));
Thread.sleep(1000);

		}
		driver.findElement(By.xpath("//input[@id='viewbutton']")).click();
	}
	
@Test(enabled=true)	
	public void css() throws InterruptedException {
	WebElement PIM=driver.findElement(By.cssSelector("div.menu:nth-child(2) ul.main-menu-first-level-unordered-list.main-menu-first-level-unordered-list-width li.main-menu-first-level-list-item:nth-child(2) a.firstLevelMenu:nth-child(1) > b:nth-child(1)"));
	Actions act=new Actions(driver);
	act.moveToElement(PIM).perform();
	Thread.sleep(1000);
	WebElement addemp=driver.findElement(By.cssSelector("#menu_pim_addEmployee"));
     addemp.click();
     Thread.sleep(1000);
     driver.findElement(By.cssSelector("#firstName")).sendKeys("sravanthi");
     driver.findElement(By.cssSelector("#lastName")).sendKeys("palakurthi");
     Thread.sleep(1000);
    WebElement upload= driver.findElement(By.xpath("//input[@id='photofile']"));
    upload.sendKeys("C:\\Users\\toshiba\\Pictures\\2019-07-08 pravesham\\pravesham 074.jpg");
    Thread.sleep(1000);
    WebElement save= driver.findElement(By.cssSelector("#btnSave"));
    save.click();
//Alert alr =(Alert)driver;
}	



}
