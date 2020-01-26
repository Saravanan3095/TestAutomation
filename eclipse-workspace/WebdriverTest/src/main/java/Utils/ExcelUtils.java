package Utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static XSSFSheet ExcelWSheet;
	 
	 private static XSSFWorkbook ExcelWBook;
	 
	 private static XSSFCell Cell;
	 
	 private static XSSFRow Row;
	 public static Object[][] getTableArray(String FilePath, String SheetName) throws Exception {   
		 String[][] tabArray = null;
		 try {
			 FileInputStream ExcelFile=new FileInputStream(FilePath);
			 ExcelWBook=new XSSFWorkbook(ExcelFile);
			 ExcelWSheet=ExcelWBook.getSheet(SheetName);
			 int startRow = 1;
			 int ci=0;
			 int startCol = 1;
			 int totalRows = ExcelWSheet.getLastRowNum();
			 int totalColumns=ExcelWSheet.getRow(0).getLastCellNum()-1;
			 System.out.println("totalRows:"+totalRows);
			 System.out.println("totalColumns:"+totalColumns);
			 tabArray=new String[totalRows][totalColumns];
			for(int i=startRow;i<=totalRows;i++,ci++) {
				int cj=0;
			 for (int j=startCol;j<=totalColumns;j++,cj++)
			 {
			 
			    tabArray[ci][cj]=getCellData(i,j);
			 
			    System.out.println(tabArray[ci][cj]);
			    
			    }
			}}catch(Exception e) {
				 e.printStackTrace();
			 
		 }
		 return tabArray;
	 }
	 public static String getCellData(int RowNum, int ColNum) throws Exception{

		   try{

			  Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);

			  String CellData = Cell.getStringCellValue();

			  return CellData;

			  }catch (Exception e){

				return"";

				}

			}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 

}
