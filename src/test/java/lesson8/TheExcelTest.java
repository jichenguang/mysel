package lesson8;



import org.testng.annotations.Test;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TheExcelTest {
	
	@Test(dataProvider = "db1")
	public void ts(Map<String, String> data) throws Exception{
		this.prmap(data);
		System.out.println("=====over=====");
		System.out.println("");
	}
	
	@DataProvider(name = "db1")
	public Iterator<Object[]> data() throws Exception{
		return (Iterator<Object[]>)new ExcelData("ExcelTest","testB");
	}
	
	public  void prmap(Map<String,String>arr){
		Set<String> set=arr.keySet();
		Iterator<String> it=set.iterator();
		while(it.hasNext()){
			String s=(String)it.next();
			 System.out.println(arr.get(s));
		}
	}

}
