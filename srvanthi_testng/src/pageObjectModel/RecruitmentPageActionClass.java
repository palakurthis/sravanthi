package pageObjectModel;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class RecruitmentPageActionClass {
	 static WebDriver driver;
	@BeforeTest
	public static void login() throws InterruptedException, IOException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selinium Web Driver\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		Thread.sleep(1000);
		LoginPageclass LPC=new LoginPageclass(driver);
		LPC.Login("Admin", "admin123", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
	}
	
	@Test(enabled=true)
	public  static void testrecruitmentpage() throws InterruptedException, IOException {
	
		RecruitmentPageClass sra=new RecruitmentPageClass(driver);
		sra.RecruitmentCandidates();
		
	}
	
@AfterTest
public void quit() {
	driver.quit();
}
}	

	
	
	
	
	
	
	

	

