package pageObjectModel;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginActionClass {
static WebDriver driver;
	
@BeforeMethod()
	public void login() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Selinium Web Driver\\drivers\\chromedriver.exe");
		 driver=new ChromeDriver();
		 Thread.sleep(1000);
}
@Test()
public static void ValidLogin() throws InterruptedException, IOException {
LoginPageclass LPC=new LoginPageclass(driver);
LPC.Login("Admin", "admin123", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
Thread.sleep(500);
SoftAssert asrt=new SoftAssert();
asrt.assertEquals(driver.getTitle(), "OrangeHRM");
}

@Test(enabled=false)
public static void ValidUInvalidP() throws InterruptedException, IOException {
 LoginPageclass LPC=new LoginPageclass(driver);
   LPC.Login("Admin", "admin1235682", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    Thread.sleep(500);
    String EM=driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
       Assert.assertEquals(EM, "Invalid credentials");
}
@Test(enabled=true)
public static void IValidUvalidP() throws InterruptedException, IOException {
 LoginPageclass LPC=new LoginPageclass(driver);
   LPC.Login("Admin", "admin1235682", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    Thread.sleep(500);
    String EM=driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
       Assert.assertEquals(EM, "Invalid credentials");

}
@Test(enabled=true)
public static void WUvalidP() throws InterruptedException, IOException {
 LoginPageclass LPC=new LoginPageclass(driver);
   LPC.Login("", "admin123", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    Thread.sleep(500);
    String EM=driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
       Assert.assertEquals(EM, "Username cannot be empty");

}

@Test(enabled=true)
public static void validUwP() throws InterruptedException, IOException {
 LoginPageclass LPC=new LoginPageclass(driver);
   LPC.Login("Admin", "", "https://opensource-demo.orangehrmlive.com/index.php/auth/login");
    Thread.sleep(500);
    String EM=driver.findElement(By.xpath("//span[@id='spanMessage']")).getText();
       Assert.assertEquals(EM, "Password cannot be empty");
driver.close();
}

@AfterTest()
public static void Quit() {
	driver.quit();
}
}
