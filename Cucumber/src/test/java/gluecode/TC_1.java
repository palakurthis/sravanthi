package gluecode;
//dfdfdsxfsx
import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TC_1  {
	
	WebDriver driver; 
	@Given("^user navigates to the url$")
	public void user_navigates_to_the_url() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "D:\\Selinium Web Driver\\drivers\\chromedriver.exe");
		   driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("http://apps.qaplanet.in/hrm/login.php");
		}

	@When("^user enters valid \"([^\"]*)\"  and \"([^\"]*)\"$")
	public void user_enters_valid_and(String userid, String password)  throws Throwable {
		WebElement usr=driver.findElement(By.xpath("//input[@name='txtUserName']"));
		 usr.sendKeys(userid);
		WebElement pd=driver.findElement(By.xpath("//input[@name='txtPassword']"));
		 pd.clear();
		 pd.sendKeys(password);
		 Thread.sleep(1000);
		// WebElement clrclass=driver.findElement(By.name("clear"));
		 //clrclass.click();
		 By login=By.xpath("//input[@name='Submit']");
		 WebElement lg=driver.findElement(login);
		 lg.click();
	}

	@Then("^home page disapleyd$")
	public void home_page_disapleyd()  throws Throwable {
		 Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		}

	@When("^user enters invalid \"([^\"]*)\"  and \"([^\"]*)\"$")
	public void user_enters_invalid_and(String inuserid, String valdpaswd) throws Throwable {
		WebElement usr=driver.findElement(By.xpath("//input[@name='txtUserName']"));
		 usr.sendKeys(inuserid);
		WebElement pd=driver.findElement(By.xpath("//input[@name='txtPassword']"));
		 pd.clear();
		 pd.sendKeys(valdpaswd);
		 Thread.sleep(1000);
		// WebElement clrclass=driver.findElement(By.name("clear"));
		 //clrclass.click();
		 By login=By.xpath("//input[@name='Submit']");
		 WebElement lg=driver.findElement(login);
		 lg.click();
	}


	@Then("^user should get an error message \"([^\"]*)\"$")
	public void user_should_get_an_error_message(String arg1) throws Throwable {
		Assert.assertEquals(driver.findElement(By.xpath("//font[contains(text(),'Invalid Login')]")).getText(), "Invalid Login");
		driver.quit();
	}

	@When("^user  passes blank value in  \"([^\"]*)\"  and \"([^\"]*)\"$")
	public void user_passes_blank_value_in_and(String bluserid, String blpassword) throws Throwable {
		   
		WebElement usr=driver.findElement(By.xpath("//input[@name='txtUserName']"));
		 usr.sendKeys(bluserid);
		WebElement pd=driver.findElement(By.xpath("//input[@name='txtPassword']"));
		 pd.clear();
		 pd.sendKeys(blpassword);
		 Thread.sleep(1000);
		// WebElement clrclass=driver.findElement(By.name("clear"));
		 //clrclass.click();
		 By login=By.xpath("//input[@name='Submit']");
		 WebElement lg=driver.findElement(login);
		 lg.click();
		}


	@Then("^user should get an alert message$")
	public void user_should_get_an_alert_message() throws Throwable {
		String alrmsg=driver.switchTo().alert().getText();
	    Assert.assertEquals(alrmsg,"User Name not given!");
	    driver.switchTo().alert().accept();
	    driver.quit();
	
	   
	}

	@When("^user click on clear button$")
	public void user_click_on_clear_button() throws Throwable {
	    driver.findElement(By.xpath("//input[@name='clear']")).click();
	  
	}

	@Then("^user name and password fields should reset to blank$")
	public void user_name_and_password_fields_should_reset_to_blank() throws Throwable {
	    Thread.sleep(1000);
	    String clear1=driver.findElement(By.xpath("//input[@name='txtUserName']")).getText();
	    String clear2=driver.findElement(By.xpath("//input[@name='txtPassword']")).getText();
	    Assert.assertEquals(clear1,"");
	    Assert.assertEquals(clear2,"");
	    
	    driver.quit();
	    }

	@When("^user click on the link Change password$")
	public void user_click_on_the_link_Change_password() throws Throwable {
	   driver.findElement(By.xpath("//a[contains(text(),'Change Password')]")).click();
	   
	}

	@Then("^user should get a change password window$")
	public void user_should_get_a_change_password_window() throws Throwable {
	   Thread.sleep(1000);
	   driver.switchTo().frame(0);
	   String chngpwd=driver.findElement(By.xpath("//h2[contains(text(),'Change Password')]")).getText();
	   Assert.assertEquals(chngpwd,"Change Password");
	   driver.quit();
	   

	}

	@When("^user click on the logout link$")
	public void user_click_on_the_logout_link() throws Throwable {
		 driver.findElement(By.linkText("Logout")).click();
	}

	@Then("^user should log out fron the applciation successfully$")
	public void user_should_log_out_fron_the_applciation_successfully() throws Throwable {
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");	
		driver.quit();
	    
	}



		
}
