package utilitiesDemo;

import utilities.ExcelUtility;

public class ExcelUtilExecution {

	public static void main(String[] args) {
		
		String[][] data=ExcelUtility.getDataFromExcelAsArray("C:\\Users\\Anuj\\Selenium_Utilities\\UtilitiesAutomation\\src\\main\\java\\resources\\TestData.xlsx", "Data");
		for(int i=0; i<4; i++)
		{
			for(int j=0; j<3; j++)
			{
				System.out.print(data[i][j]);
			}
			System.out.println("\n");
		}

	}

}
