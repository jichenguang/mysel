package lesson14;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParamTestWithDataProvider2 {
	
/*	@DataProvider(name = "test2")
	public static Object[][]  primeNumbers(){
		return new Object[][] {
			{ new Bean("hi I am the bean", 111) }
		};
	}	*/
	
	
	@DataProvider(name = "test2")
	public static Object[][] primeNumbers(){// Object[][]为固定形式，无论多少参数，都是两个[][]
		return new Object[][]{
			{ new Bean("kjkj",8, 9) }
		};
	}	
		
	@Test(dataProvider="test2")
	public static void testMethod(Bean myBean) {
		System.out.println(myBean.getVal() + " " + myBean.getI()+" "+myBean.getQ());
	}
}
