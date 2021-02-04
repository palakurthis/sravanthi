package pageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageclass {

WebDriver driver;


public LoginPageclass(WebDriver driver) {
	this.driver=driver;
}

public void Login(String Username,String Password,String Url) throws InterruptedException, IOException {
	driver.get(Url);
	Thread.sleep(1000);
	File src=new File("D:\\Selinium Web Driver\\Excel\\Locators.xlsx");
	FileInputStream Fl=new FileInputStream(src);
	XSSFWorkbook wb = new XSSFWorkbook(Fl);
	XSSFSheet sheet=wb.getSheetAt(0);
	Thread.sleep(1000);
//	System.out.println(sheet.getRow(1).getCell(2).getStringCellValue());
	By Usernamel=By.xpath(sheet.getRow(1).getCell(2).getStringCellValue());
	By Passwordl=By.xpath(sheet.getRow(2).getCell(2).getStringCellValue());
	By Loginl=By.xpath(sheet.getRow(3).getCell(2).getStringCellValue());
	wb.close();
  
	driver.findElement(Usernamel).sendKeys(Username);
	driver.findElement(Passwordl).sendKeys(Password);
	Thread.sleep(500);
	driver.findElement(Loginl).click();
}

}
