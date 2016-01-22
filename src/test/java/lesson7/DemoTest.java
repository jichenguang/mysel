package lesson7;

public class DemoTest {
	
	static String url = "file:///Users/700sfriend/Desktop/demo.html";
	
	public static void main(String[] args) {
        Demo d = new Demo();
        d.testGoTo(url);
    /*    d.testInput("hello");
        d.testLink();
        d.testRadioBox(2);*/
        d.testSelect("opel");
      /*  d.testCheckBox(2);
        d.testButton();
        d.testUpload("c:\\test.txt");
        d.testAlert();
        d.testAction();
        d.testJavaScript();*/
        d.testWait();
        
        
        d.testQuit();
	}

}
