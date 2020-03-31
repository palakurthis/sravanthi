//updated by sravanthi----------test
package ProjectGID.ProjectAID;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginTest {
  @Test
  public void f() throws InterruptedException {
	  System.setProperty("webdriver.chrome.driver", "D:\\Selinium Web Driver\\drivers\\chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("http://apps.qaplanet.in/hrm/login.php");
	WebElement usr=driver.findElement(By.xpath("//input[@name='txtUserName']"));
	usr.sendKeys("qaplanet1");
	WebElement pd=driver.findElement(By.xpath("//input[@name='txtPassword']"));
	 pd.clear();
	 pd.sendKeys("lab1");
	 Thread.sleep(1000);
	// WebElement clrclass=driver.findElement(By.name("clear"));
	 //clrclass.click();
	 By login=By.xpath("//input[@name='Submit']");
	 WebElement lg=driver.findElement(login);
	 lg.click();
	
  }
}
