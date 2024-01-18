package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.aventstack.extentreports.ExtentTest;

public class ExcelDataProvider extends BaseClass {
	static ExtentTest test;
	Workbook wb;
	FileInputStream fis;
	FileOutputStream outFile;
	String data = "";
	String path = "";
	String Org = "";

	public ExcelDataProvider() throws Exception {

		String env = config.get_Env();

		if (env.equalsIgnoreCase("https://preprod.ntp.net.in/")) {

			data = config.get_PreProd_test_data();

		} else if (env.equalsIgnoreCase("https://vdn.diksha.gov.in/")) {

			data = config.get_Prod_test_data();
			

		} else {
			System.out.println("Config is not initialize properly. Please check config.properties file");

		}

		path = System.getProperty("user.dir") + data;
		FileInputStream fis = new FileInputStream(path);
		wb = WorkbookFactory.create(fis);

	}

	public String getExcelData(String sheetname, int row, int cell) {

		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();

	}
	

    public String readDataForDownloadedQRCodeFile() {
    	
    	String value= null;
    	String filePath = "C:\\Users\\Ashish.Dubey\\Downloads\\e2257771-b719-4ce4-9044-05759183cc24.csv";
        try {
           File file= new File(filePath);
            FileInputStream fis = new FileInputStream(file);

            Workbook workbook = new XSSFWorkbook(fis);
            String sheet ="e2257771-b719-4ce4-9044-0575918"; 
            int row=1;
            int cell=1;
            
             value=workbook.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
            
           System.out.println(value);

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       return value;
		
    }
	
	
	

	public void updateData(String sheetName, String Data1, String Data2, String Data3) throws IOException

	{

		// Setting path of the excel test data file

		// Creating excel objects

		Sheet sheet = wb.getSheet(sheetName); // get the first sheet in the workbook

		int lastRowNum = sheet.getLastRowNum();
		Row dataRow = sheet.createRow(++lastRowNum);

		Cell cell1 = dataRow.createCell(0);
		Cell cell2 = dataRow.createCell(1);
		Cell cell3 = dataRow.createCell(2);

		cell1.setCellValue(Data1);
		cell2.setCellValue(Data2);
		cell3.setCellValue(Data3);

		//fis.close();

		FileOutputStream fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
	}

	public String[] getCredentails(String user) throws IOException {

		String[] cred = { "", "" };
		String sheetname = "Credentials";
		String username = "";
		String password = "";
		String role = "";

		Sheet sheet = wb.getSheet(sheetname);

		int lastRowNum = (sheet.getLastRowNum()) + 1;

		for (int i = 1; i <= lastRowNum; i++) {

			role = sheet.getRow(i).getCell(0).getStringCellValue();
			if (role.equals(user)) {
				
				username = sheet.getRow(i).getCell(1).getStringCellValue();
				password = sheet.getRow(i).getCell(2).getStringCellValue();

				break;
			}

		}
		cred[0] = username;
		cred[1] = password;
		return cred;

	}

	public String getContentName(String contentType) throws IOException {

		String contentName = "";
		String sheetname = "TestData";

		int typeCell = 0;
		int dataCell = 1;

		Sheet sheet = wb.getSheet(sheetname);
		int lastRowNum = (sheet.getLastRowNum());

		for (int rowIndex = lastRowNum; rowIndex >= 1; rowIndex--) {

			Row row_Type = sheet.getRow(rowIndex);
			Row row_Data = sheet.getRow(rowIndex);

			Cell cell_Type = row_Type.getCell(typeCell);
			Cell cell_Data = row_Data.getCell(dataCell);

			if (cell_Type.getStringCellValue().equals(contentType)) {

				contentName = cell_Data.getStringCellValue();
				rowIndex = 0;

			}
		}

		return contentName;
	}

	public String getDoID(String contentType) throws IOException {

		String doID = "";
		String sheetname = "TestData";
		int typeCell = 0;
		int dataCell = 2;

		Sheet sheet = wb.getSheet(sheetname);
		int lastRowNum = (sheet.getLastRowNum());

		for (int rowIndex = lastRowNum; rowIndex >= 1; rowIndex--) {

			Row row_Type = sheet.getRow(rowIndex);
			Row row_Data = sheet.getRow(rowIndex);

			Cell cell_Type = row_Type.getCell(typeCell);
			Cell cell_Data = row_Data.getCell(dataCell);

			if (cell_Type.getStringCellValue().equals(contentType)) {

				doID = cell_Data.getStringCellValue();
				rowIndex = 0;

			}
		}
		return doID;

	}

}
