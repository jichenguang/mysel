package lesson11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class tableCell{
	
			public static String url ="file:///Users/700sfriend/git/mysel/test.html";
			
			public static String tabletest(WebDriver Driver,int rows, int columns)
			
			{	
				Driver.get(url);
			    String text = null;
			    //avoid get the head line of the table
			    rows=rows+1;
			    
			    /*@
			     * 获取table的base xpath，这个所谓的base xpath是指这个table的第n行第m列相同的部分，然后通过传入n,m获取返回值
			     */
			    String xpath="//*[@id='table138']/tbody/tr["+rows+"]/td["+columns+"]";
			    
			    WebElement table=Driver.findElement(By.xpath(xpath)); //*[@id="table138"]/tbody/tr[1]/td[1]/strong
			    text=table.getText();
			    System.out.println(text);
			    return text;
			    
			}
}