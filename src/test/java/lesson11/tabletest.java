package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


@Test
public class tabletest{
	
			public static int rows = 1;
			public static int columns =1;
			public static WebDriver Driver = new FirefoxDriver();
			
			
			public static  void tableTest()
			
			{
			    	tableCell.tabletest(Driver, rows, columns);
			    	
			    
			}
			
			
}