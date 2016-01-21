package lesson6;

import org.testng.Assert;
import org.testng.annotations.Test;

public class IgnoreTest {
    String message = "Manisha";
    MessageUtil messageUtil = new MessageUtil(message);

    @Test(enabled = false)
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        message = "Manisha";
	Assert.assertEquals(message, messageUtil.printMessage());
    }

    @Test(enabled = false)
    public void testSalutationMessage() {
        System.out.println("Inside testSalutationMessage()");
	message = "Hi!" + "Manisha";
	Assert.assertEquals(message, messageUtil.salutationMessage());
    }
    
    @Test(enabled = true)
    public void testSalutationMessageandtestPrintMessage() {
        System.out.println("Inside testSalutationMessage()");
	message = "Hello!" + "Manisha";
	Assert.assertEquals(message, messageUtil.salutationMessage());
    }
}