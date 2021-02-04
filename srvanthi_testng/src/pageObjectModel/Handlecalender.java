/**
 * 
 */
package pageObjectModel;

import java.util.List;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author toshiba
 *
 */
public class Handlecalender {
	static WebDriver driver;
@BeforeTest 
public void login() throws InterruptedException, IOException
{
	System.setProperty("webdriver.chrome.driver", "D:\\Selinium Web Driver\\drivers\\chromedriver.exe");
	Thread.sleep(1000);
	driver=new ChromeDriver();
	LoginPageclass lg=new LoginPageclass(driver);
	lg.Login("Admin", "admin123", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	Thread.sleep(1000);
}
@SuppressWarnings("unused")
@Test
public void handlecalender() throws InterruptedException {
	Actions act=new Actions(driver);
	driver.findElement(By.xpath("//a[@id='menu_time_viewTimeModule']")).click();
	Thread.sleep(1000);
	act.moveToElement(driver.findElement(By.xpath("//a[@id='menu_time_Reports']"))).perform();
	driver.findElement(By.xpath("//a[@id='menu_time_displayProjectReportCriteria']")).click();
	Thread.sleep(1000);
	Select sl=new Select(driver.findElement(By.xpath("//select[@id='time_project_name']")));
	sl.selectByIndex(4);
	Thread.sleep(1000);
	driver.findElement(By.xpath("//body/div[@id='wrapper']/div[@id='content']/div[1]/div[2]/form[1]/fieldset[1]/ol[1]/li[2]/img[1]")).click();
	Thread.sleep(1000);
	List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
	for(int i=0;i<dates.size();i++)
	{
		if(dates.get(i).getText().equals("21")) {
			dates.get(i).click();
		break;
//	System.out.println(dates.get(i).getText());
		}
	}
	//driver.close(); 
}

}
