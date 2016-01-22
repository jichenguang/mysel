package lesson7;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


/**
 * Created with IntelliJ IDEA.
 * User: Mr_Tank_
 * Date: 13-11-29
 * Time: 下午9:52
 * To change this template use File | Settings | File Templates.
 */
public class seleniumTest {


    public static void main(String args[]){
//        System.getProperties().setProperty("webdriver.chrome.driver", "E:\\driver\\chromedriver.exe");
        WebDriver webDriver =new FirefoxDriver();
        webDriver.get("http://list.jd.com/9987-653-655-0-0-0-0-0-0-0-1-1-1-1-1-72-4137-33.html");

/*        WebElement webElement = webDriver.findElement(By.xpath(".//*[@id='plist']/ul"));

        System.out.print(webElement.getAttribute("outerHTML"));*/

        WebElement li=webDriver.findElement(By.xpath(".//*[@id='plist']/ul/li[1]/div"));

        String name=webDriver.findElement(By.xpath(".//*[@id='plist']/ul/li[1]/div/div[4]/a/em")).getText();
        System.out.println("商品名:"+name);

        String price=webDriver.findElement(By.xpath(".//*[@id='plist']/ul/li[1]/div/div[3]/strong/i")).getText();
        System.out.println("价格:"+price);

        String eva=webDriver.findElement(By.xpath(".//*[@id='plist']/ul/li[1]/div/div[5]/strong")).getText();
        System.out.println("评价:"+eva);

        webDriver.close();
    }
}
