package lesson2;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class GroupTest {
	 @Test(groups = {"systemtest"})
	    public void testLogin(){
	        System.out.println("this is test login");
	    }
	    
	    @Test(groups = {"functiontest"})
	    public void testOpenPage(){
	        System.out.println("this is test Open Page");
	    }
	}

