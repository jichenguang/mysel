package lesson12;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class getCell {
	
	
	/*
	 *   根据Row对象，及给定的数字，获取列
	 */
		
	
	static WebElement getCell(WebElement Row,int cell){
		 List<WebElement> cells;
		 WebElement target = null;
		 //列里面有"<th>"、"<td>"两种标签，所以分开处理。
		 if(Row.findElements(By.tagName("th")).size()>0){
			cells = Row.findElements(By.tagName("th"));
			target = cells.get(cell);
		 }
		 if(Row.findElements(By.tagName("td")).size()>0){
			cells = Row.findElements(By.tagName("td"));
			target = cells.get(cell);
		 }
		return target;
	}
}
