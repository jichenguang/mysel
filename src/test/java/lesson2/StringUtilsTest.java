package lesson2;


import org.testng.annotations.Test; 

public class StringUtilsTest 
{ 
	 @Test 
	 public void isEmpty() 
	 { 
		 assert org.apache.commons.lang3.StringUtils.isBlank(null); 
		 assert org.apache.commons.lang3.StringUtils.isBlank(""); 
	 } 
	 @Test 
	 public void trim() 
	 { 
		 assert "foo".equals(org.apache.commons.lang3.StringUtils.trim("  foo   ")); 
	 } 
}
