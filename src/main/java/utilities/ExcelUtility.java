package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static String[][] getDataFromExcelAsArray(String filepath, String sheetname) {
		String[][] data = null;
		try {

			File file = new File(filepath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workBook.getSheet(sheetname);
			Iterator<Row> row = sheet.iterator();
			int rowCount = 0;
			while (row.hasNext()) {
				row.next();
				rowCount++;
			}
			int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
			data = new String[rowCount][colCount];
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < colCount; j++) {
					if (sheet.getRow(i).getCell(j).getCellType() == CellType.STRING) {
						data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
					} else if (sheet.getRow(i).getCell(j).getCellType() == CellType.NUMERIC) {
						data[i][j] = NumberToTextConverter.toText(sheet.getRow(i).getCell(j).getNumericCellValue());
					}
				}
			}
		} catch (Exception e) {
		}
		return data;
	}

	public static boolean verifyColumnIsPresent(String filepath, String sheetname, String ColName) {

		boolean condition = false;
		try {
			File file = new File(filepath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workBook.getSheet(sheetname);
			Row row = sheet.getRow(0);
			int cellCount = row.getPhysicalNumberOfCells();
			for (int i = 0; i < cellCount; i++) {
				String value = sheet.getRow(0).getCell(i).getStringCellValue();
				if (value.equalsIgnoreCase(ColName)) {
					condition = true;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return condition;

	}

	public void verifyValueInColumn(String filepath, String sheetname, String ColName, String value) {

		try {
			File file = new File(filepath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workBook.getSheet(sheetname);
			int indexOfColumn=getColumnIndex(filepath,sheetname,ColName);
			int rows=sheet.getPhysicalNumberOfRows();
			for(int i=1;i<rows;i++)
			{
				
			}
			

		} catch (Exception e) {

		}

	}
	
	public static int getColumnIndex(String filepath, String sheetname, String ColName)
	{
		int index=-1;
		try {
			File file = new File(filepath);
			FileInputStream inputStream = new FileInputStream(file);
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet sheet = workBook.getSheet(sheetname);
			Row row=sheet.getRow(0);
			int noOfCells=row.getPhysicalNumberOfCells();
			for(int i=0;i<noOfCells; i++ )
			{
				String value=row.getCell(i).getStringCellValue();
				if(value.equalsIgnoreCase(ColName))
				{
					index=i;
				}
			}
			

		} catch (Exception e) {

		}
		return index;
	}
}
