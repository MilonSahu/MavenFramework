package General;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	String path="C:\\Users\\TYSS\\Desktop\\java\\milon\\src\\test\\resources\\YahooData.xlsx";
	
public String getExceldata(String sheetname, int rownum, int colnum) throws Throwable
{
	
	FileInputStream fis=new FileInputStream(path);
	Workbook wb=WorkbookFactory.create(fis);
	Sheet sh=wb.getSheet(sheetname);
	Row row=sh.getRow(rownum);
	String data=row.getCell(colnum).getStringCellValue();
	wb.close();
	return data;
}
public void setExcelData(String sheetname,int rownum,int colnum,String data) throws Throwable
{
 FileInputStream fis=new FileInputStream(path);
 Workbook wb=WorkbookFactory.create(fis);
 Sheet sh=wb.getSheet(sheetname);
 Row row=sh.getRow(rownum);
 Cell cel=row.createCell(colnum);
 cel.setCellValue(data);
 FileOutputStream fos=new FileOutputStream(path);
 wb.write(fos);
 wb.close();
}
}

