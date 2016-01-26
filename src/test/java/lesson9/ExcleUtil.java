package lesson9;

import java.io.File;
import jxl.Workbook;
import jxl.format.Colour;
import jxl.format.UnderlineStyle;
import jxl.write.DateFormat;
import jxl.write.Label;
import jxl.write.Number;
import jxl.write.DateTime;
import jxl.write.Boolean;
import jxl.write.NumberFormat;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class ExcleUtil {
	public static void main(String[] args) {
		//生成一个可读取的excel文件对象
		File xlsFile = new File("D:\\myfile.xls");
		WritableWorkbook workbook = null;
		WritableSheet sheet = null;
		try {
			workbook = Workbook.createWorkbook(xlsFile);
			//添加第一个工作表
			sheet = workbook.createSheet("sheetName", 0);
			//添加表头Label(列，行，内容) 不知道为什么要先列后行
			sheet.addCell(new Label(0, 0, "中文"));
			sheet.addCell(new Label(1, 0, "甲骨文"));
			
			sheet.addCell(new Label(0, 1, "整数"));
			sheet.addCell(new Number(1, 1, 30));
			
			sheet.addCell(new Label(0, 2, "小数"));
			sheet.addCell(new Number(1, 2, 30.12345));
			
			sheet.addCell(new Label(0, 3, "字体"));
			WritableFont wf = new WritableFont(WritableFont.TIMES,12,WritableFont.BOLD,true,UnderlineStyle.SINGLE,Colour.RED);
			WritableCellFormat cf = new WritableCellFormat(wf);
			sheet.addCell(new Label(1, 3, "加粗红色",cf));
			
			sheet.addCell(new Label(0, 4, "小数格式化"));
			NumberFormat nf = new NumberFormat("#.##");
			WritableCellFormat cf2 = new WritableCellFormat(nf);
			sheet.addCell(new Number(1, 4, 30.12345,cf2));
			
			sheet.addCell(new Label(0, 5, "布尔值"));
			sheet.addCell(new Boolean(1, 5, false));
			
			sheet.addCell(new Label(0, 6, "时间格式化"));
			DateFormat df = new DateFormat("yyyy-MM-dd hh:mm:ss");
			WritableCellFormat cf3 = new WritableCellFormat(df);
			sheet.addCell(new DateTime(1, 6, new java.util.Date(),cf3));
			
			sheet.mergeCells(0,7,1,8);
			sheet.addCell(new Label(0, 7, "合并单元格"));
			
			workbook.write();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}