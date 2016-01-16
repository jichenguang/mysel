package lesson1;

import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
  
public class NewTest{
    public static void main(String[] args) throws InterruptedException {
    	
    	WebDriver driver = new FirefoxDriver();
        driver.get("http://www.700store.com/houjiemini");
     
        //这两句不能省略
        WebElement element=driver.findElement(By.xpath(".//*[@id='form1']/div[3]/div/div/div[1]/a"));
        element.click();
        
        System.out.println(driver.manage().getCookieNamed("ASP.NET_SessionId") ); 
        
        Thread.sleep(3000);
        driver.quit();      
        }
}