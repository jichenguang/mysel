package lesson9;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;

import jxl.Workbook;
import jxl.write.WritableWorkbook;

public class ex {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
/*		
 * // 文件路径
		
		String url="/Users/700sfriend/git/mysel/test2.xlsx";
		//创建文件
		OutputStream os=new FileOutputStream(url);	
		WritableWorkbook wwb=Workbook.createWorkbook(os);
		*/
		
/*		File directory = new File(".");
		String ss = "open/myExcel/";
		String myPath = "/Users/700sfriend/git/mysel/ExcleDate.xlsx";
		OutputStream tt = new FileOutputStream(myPath);
		WritableWorkbook wwb2 = Workbook.createWorkbook(tt);*/
		
		
//		File file = new File("/Users/700sfriend/git/mysel/123/");
//		File file = new File("/Users/700sfriend/git/mysel/htll/");
		
		File directory = new File(".");
		
		String ss = "/open/myExcel/";
		
		String path = directory.getCanonicalPath()+ss;
		
		System.out.println(path);
		File file = new File(path);

		
/*        System.out.println("-----------------readTextA_ByProjectRelativePath---------------------"); 
        File f = new File("src/com/lavasoft/res/a.txt"); */

	}

}
