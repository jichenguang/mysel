package lesson3;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import org.testng.annotations.*;
import org.testng.Assert;


public class TestHelloWorldTestNG_Fail {

    WebDriver driver;
    @Test
    public void helloWorld() throws Exception {        
        //如果火狐浏览器没有默认安装在C盘，需要制定其路径
        //System.setProperty("webdriver.firefox.bin", "D:/Program Files/Mozilla firefox/firefox.exe"); 
        driver = new FirefoxDriver();
        driver.get("http://www.baidu.com/");
        
        driver.manage().window().maximize();
        
        WebElement txtbox = driver.findElement(By.name("wd"));
        txtbox.sendKeys("Glen");
        
        WebElement btn = driver.findElement(By.id("su"));
        btn.click();
                
        String expectedTitle = "Glen_百度";
        String actualTitle = driver.getTitle();
        
        AssertJUnit.assertEquals(actualTitle,expectedTitle);
    }
    
    @AfterMethod
	@AfterTest
    public void tearDown(){
        driver.quit();
    }

}