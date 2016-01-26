package lesson12;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Table {

	/**
	 * @author gongjf
	 */
//	private WebDriver driver;
//	
//	Table(WebDriver driver){
//		
//		this.driver = driver;
//	}
//	
	/** 从一个table的单元格中得到文本值. 参数tableCellAddress的格式为
	row.column, 行列从0开始.
	@param by  用于得到table对象
	@param tableCellAddress 一个单元格地址, 如. "1.4"
	@return 从一个table的单元格中得到文本值
	*/
	

	
	
//	public static void main(String[] args) {
	
	@Test
	public static void Tabletest(){
		 WebDriver driver;
		 String Url = "file:///Users/700sfriend/Desktop/testtable.html";
//		 System.setProperty("webdriver.firefox.bin","D:\\Program Files\\Mozilla Firefox\\firefox.exe");
		 
		 
		 driver = new FirefoxDriver();		 
		 driver.get(Url);
	
//		 Table table = new Table(driver);
		 By by = By.id("myTable");
		 String address = "0.1";
	 
		 System.out.println(getCellText.getCellText(by, address,driver));
		
		
	}

}
