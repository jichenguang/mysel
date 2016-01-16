package lesson1;

import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class testBaidu {
	
	
	
	@Test
	/**
	 * 打开google搜索百度
	 * 
	 * @param queryStr
	 */
	public    void demo() {
		String url = "http://www.baidu.com";

		WebDriver webDriver = new FirefoxDriver();
		// 打开google
		webDriver.get(url);

		// 使用Selenium的dom模型获取form
		WebElement webElement = webDriver.findElement(By.name("wd"));
		webElement.sendKeys("baidu");
		webElement.submit();

		// 通过判断 title 内容等待搜索页面加载完毕，Timeout 设置10秒

		(new WebDriverWait(webDriver, 30)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				return d.getTitle().toLowerCase().indexOf("百度_百度搜索") != -1;
			}
		});
		
		

		String responseBody = webDriver.getPageSource();
		System.out.println("Response : " + responseBody);

		// 关闭浏览器
		webDriver.close();
	}

}
