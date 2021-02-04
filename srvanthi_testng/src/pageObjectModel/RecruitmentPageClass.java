package pageObjectModel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RecruitmentPageClass {
  WebDriver driver;
public RecruitmentPageClass(WebDriver driver) {
	this.driver=driver;
}
public void RecruitmentCandidates() throws IOException, InterruptedException {
	File src=new File("D:\\Selinium Web Driver\\Excel\\Locators.xlsx");
	FileInputStream Fl=new FileInputStream(src);

XSSFWorkbook wb=new XSSFWorkbook(Fl);
XSSFSheet sheet=wb.getSheetAt(1);
By Recruitment=By.xpath(sheet.getRow(1).getCell(2).getStringCellValue());
By Candidates=By.xpath(sheet.getRow(2).getCell(2).getStringCellValue());
//By Vacancies=By.xpath(sheet.getRow(3).getCell(2).getStringCellValue());
 By JobTitle=By.xpath(sheet.getRow(4).getCell(2).getStringCellValue());
By vacancy=By.xpath(sheet.getRow(5).getCell(2).getStringCellValue());
By HiringManager=By.xpath(sheet.getRow(6).getCell(2).getStringCellValue());
By Status=By.xpath(sheet.getRow(7).getCell(2).getStringCellValue());
By MethodofApplication=By.xpath(sheet.getRow(8).getCell(2).getStringCellValue());
By Search=By.xpath(sheet.getRow(9).getCell(2).getStringCellValue());
wb.close();
//By Reset=By.xpath(sheet.getRow(10).getCell(2).getStringCellValue());
//Actions act=new Actions(driver);
driver.findElement(Recruitment).click();;
Thread.sleep(1000);
driver.findElement(Candidates).click();
Thread.sleep(1000);
Select GDD1=new Select(driver.findElement(JobTitle));
GDD1.selectByIndex(1);
Thread.sleep(1000);
Select GDD2=new Select(driver.findElement(vacancy));
GDD2.selectByIndex(1);
Thread.sleep(1000);
Select GDD3=new Select(driver.findElement(HiringManager));
GDD3.selectByIndex(1);
Thread.sleep(1000);
driver.findElement(Search).click();

}




}
