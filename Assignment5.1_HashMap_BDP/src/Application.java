import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * @author Benjamin Powell
 */
public class Application  {
	
	public static HashMap<String , String> excelToHash(String path , String sheetName) throws IOException {
		
		
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		XSSFSheet sheet = workBook.getSheet(sheetName);
		
		
		HashMap<String , String> map = new HashMap<String , String>();
		
		for (int i = 0; i<= sheet.getLastRowNum(); i++) {
			String key = sheet.getRow(i).getCell(0).getStringCellValue();
			
			String value = sheet.getRow(i).getCell(1).getStringCellValue();
			
			map.put(key, value);			
		}//end of for loop
		return map;
	}//end of excelToHash
	//used geeks 4 geeks to learn apache poi and how to read excel files and how to import librarys into eclipse using maven project
	
	
	public static void main (String [] args) throws IOException {
		HashMap map = excelToHash("C:\\Users\\bpowell2\\eclipse-workspace_2021-06\\readThis\\DictionaryWordValuePairs.xlsx","Sheet1");
		
		
		System.out.println(map.get("appetency"));
		System.out.println(map.get("shrift"));
		System.out.println(map.get("plight"));
		System.out.println(map.get("uncommon"));
		System.out.println(map.get("sea coal"));
		
		
	}//end of main

}// end of class 