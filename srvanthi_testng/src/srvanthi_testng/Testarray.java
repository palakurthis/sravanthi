	package srvanthi_testng;
	
	import org.testng.annotations.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.testng.annotations.Test;
	
		public class Testarray {
		String Buildpath="https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		
	@Test(enabled=true,priority=1,groups="Testarray")
	public void TC1() throws InterruptedException {
			 System.setProperty("webdriver.chrome.driver", "D:\\Selinium Web Driver\\drivers\\chromedriver.exe");
			 Thread.sleep(2000);
			 WebDriver driver=new ChromeDriver();
		 Thread.sleep(2000);
	driver.get(Buildpath);
	WebElement username=driver.findElement(By.xpath("//input[@id='txtUsername']"));
	String[][] un={ {"Admin","Login","broker"}, {"Admin","Login","broker"}};
	int n=un.length;
	int i,j;
	for(i=0;i<n;i++) {
		for(j=0;j<n;j++) {
			Thread.sleep(1000);
		username.sendKeys(un[i][j]);
		username.clear();
		Thread.sleep(1000);
		}
	
	}
	
	driver.close();
	}
	}
