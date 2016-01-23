package lesson7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import static org.junit.Assert.*;
import org.junit.Test;




/*
* 对下拉框进行操作时首先要定位到这个下拉框，new 一个Selcet对象，然后对它进行操作。 在执行上面的例子时需要导入
* org.openqa.selenium.support.ui.Select类。首先创建一个Select癿对象，isMultiple()用来判断是丌是多选下拉框
* Select类提供了3种方法来选择下拉选项
* selectByVisibleText()，selectByValue(),selectByIndex()。
* 在使用返些方法癿时候要注意下拉列表是否是动态变化的 。
*/


public class SelectAppleTest {
	@Test
	public void testDropdown() {
		WebDriver driver = new FirefoxDriver();
		driver.get("https://appleid.apple.com/cgi-bin/WebObjects/MyAppleId.woa/wa/createAppleId");
		
		// 通过下拉列表中选项的索引选中第二项，
		/*
		 * 单选下拉框
		 * 通过selectByIndex()去选择某一项,再通过 getFirstSelectedOption()就可以得到所选择的项， 再调 用 getText() 就可以得到本文。
		 */
		
		Select sq1 = new Select(driver.findElement(By.id("question0")));		       
		System.out.println(sq1.isMultiple());//isMultiple()用来判断是丌是多选下拉框		
		sq1.selectByIndex(2);
		String value1 = sq1.getFirstSelectedOption().getText();
		System.out.println(value1);
		

/*		// 通过下拉列表中的选项的value属性选中"January"value=1 这一项
		Select selectMon = new Select(driver.findElement(By.id("month")));
		selectMon.selectByValue("1");
		assertFalse(selectMon.isMultiple());// 验证下拉列表的不支持多选
		// assertEquals(4,selectMon().size()); //验证下拉数量
		Select selectDay = new Select(driver.findElement(By.id("day")));
		selectDay.selectByVisibleText("23");*/
		/** 检查下拉列表的选项 */
		// 预期的选项内容StateOptions
		//	s = s + "\"" + e.getText() + "\"" + ",";
		List<String> StateOptions = Arrays.asList(new String[] {
				"阿尔巴尼亚","阿尔及利亚","阿富汗","阿根廷","阿拉伯联合酋长国","阿鲁巴","阿曼","阿塞拜疆",
				"埃及","埃塞俄比亚","爱尔兰","爱沙尼亚","安道尔","安哥拉","安圭拉岛","安提瓜和巴布达","奥地利","澳大利亚",
				"巴巴多斯","巴布亚新几内亚","巴哈马","巴基斯坦","巴拉圭","巴勒斯坦领土","巴林","巴拿马","巴西","白俄罗斯","百慕大",
				"保加利亚","北马里亚纳群岛","贝宁","比利时","冰岛","波多黎各","波兰","波斯尼亚和黑塞哥维那","玻利维亚","伯利兹","博茨瓦纳",
				"不丹","布基纳法索","布隆迪","布维岛","赤道几内亚","丹麦","德国","东帝汶","多哥","多米尼加","多米尼加共和国","俄罗斯",
				"厄瓜多尔","厄立特里亚","法国","法罗群岛","法属玻利尼西亚","法属圭亚那","法属南方领土","梵蒂冈","菲律宾","斐济","芬兰",
				"佛得角","福克兰群岛","冈比亚","刚果共和国","刚果民主共和国","哥伦比亚","哥斯达黎加","格林纳达","格陵兰","格鲁吉亚"
				,"瓜德罗普岛","关岛","圭亚那","哈萨克斯坦","海地","韩国","荷兰","荷兰加勒比区","荷属安的列斯","荷属圣马丁","赫德和麦克唐纳群岛",
				"洪都拉斯","基里巴斯","吉布提","吉尔吉兹斯坦","几内亚","几内亚比绍","加拿大","加纳","加蓬","柬埔寨","捷克共和国","津巴布韦",
				"喀麦隆","卡塔尔","开曼群岛","科科斯（基林）群岛","科摩罗","科特迪瓦","科威特","克罗地亚","肯尼亚","库克群岛","库拉索岛",
				"拉脱维亚","莱索托","老挝","黎巴嫩","立陶宛","利比里亚","列支敦士登","留尼旺岛","卢森堡","卢旺达","罗马尼亚","马达加斯加",				
				"美国本土外小领地","美属萨摩亚","美属维尔京群岛","蒙古","蒙特塞拉特岛","孟加拉国","秘鲁","密克罗尼西亚","缅甸","摩尔多瓦",
				"摩洛哥","摩纳哥","莫桑比克","墨西哥","纳米比亚","南非","南极洲","南乔治亚岛和南桑威奇群岛","瑙鲁","尼泊尔","尼加拉瓜","尼日尔",
				"尼日利亚","纽埃","挪威","诺福克岛","帕劳","皮特克恩","葡萄牙","日本","瑞典","瑞士","萨尔瓦多","塞尔维亚","塞拉利昂","塞内加尔",
				"塞浦路斯","塞舌尔","沙特阿拉伯","圣诞岛","圣多美和普林西比","圣赫勒拿","圣基茨和尼维斯","圣卢西亚","圣马力诺","圣皮埃尔和密克隆",
				"圣文森特和格林纳丁斯","斯里兰卡","斯洛伐克","斯洛文尼亚","斯瓦尔巴岛和扬马延岛","斯威士兰","苏里南","所罗门群岛","索马里",
				"塔吉克斯坦","台湾","泰国","坦桑尼亚","汤加","特克斯和凯科斯群岛","特立尼达和多巴哥","突尼斯","图瓦卢","土耳其","土库曼斯坦",
				"托克劳群岛","瓦利斯群岛和富图纳群岛","瓦努阿图","危地马拉","维尔京群岛（英属）","委内瑞拉","文莱","乌干达","乌克兰","乌拉圭"
				,"乌兹别克斯坦","西班牙","西撒哈拉","希腊","新加坡","新喀里多尼亚","新西兰","匈牙利","牙买加","亚美尼亚","也门","伊拉克",
				"以色列","意大利","印度","印度尼西亚","英国","英属印度洋领地","约旦","越南","赞比亚","乍得","直布罗陀","智利","中非共和国",
				"中国","中国澳门特别行政区","中国香港特别行政区"});

		/** 遍历一下下拉列表所有选项，用click进行选中选项 **/
		Select selectState = new Select(driver.findElement(By.id("countryOptions")));
		List<String> my_StateOptions = new ArrayList<String>();
		/*判断选择内容*/
		 assertEquals("中国", selectState.getFirstSelectedOption().getText());
		/*将实际的下拉列表内容注入到act_StateOptions中，进行比较.*/		
		for (WebElement e : selectState.getOptions()) {
			e.click();
			my_StateOptions.add(e.getText());
		}
		assertArrayEquals(StateOptions.toArray(), my_StateOptions.toArray());

	}
}
