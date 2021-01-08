package ProjectGID.ProjectAID;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class BCMD {
  @Test
  public void bcmd() throws AWTException, InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selinium Web Driver\\drivers\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get("http://apps.qaplanet.in/hrm/login.php");
	  Thread.sleep(1000);



//((JavascriptExecutor) driver).executeScript("window.open()");
//ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//
//driver.switchTo().window(tabs.get(1));
//driver.switchTo().window(tabs.get(2));
//	  //Call switchToTab() function to switch to 1st tab
//	 
  
  }
}
