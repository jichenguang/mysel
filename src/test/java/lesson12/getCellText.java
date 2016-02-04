package lesson12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class getCellText {
	
	public static String getCellText(By by,String tableCellAddress, WebDriver driver) {
		//得到table元素对象
		WebElement table = driver.findElement(by);
		//对所要查找的单元格位置字符串进行分解，得到其对应行、列。
		int index = tableCellAddress.trim().indexOf('.');// 返回.的位置；
		int row =  Integer.parseInt(tableCellAddress.substring(0, index));
		int cell = Integer.parseInt(tableCellAddress.substring(index+1));
		//得到table表中所有行对象，并得到所要查询的行对象。
		 List<WebElement> myrows = table.findElements(By.tagName("tr"));	 
		 WebElement theRow = myrows.get(row);
		 System.out.println(theRow.getAttribute("data-product"));
		 //调用getCell方法得到对应的列对象，然后得到要查询的文本。
		 WebElement target = getCell.getCell(theRow, cell);		 
		 String text = target.getText();
		 return text;
	}

}
