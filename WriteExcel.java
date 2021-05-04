package Learning;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, IOException {
		XSSFWorkbook wbook = new XSSFWorkbook("./data/Sample.xlsx");
		XSSFSheet sheet = wbook.getSheetAt(0);
         
        Object[][] bookData = {
                {"Divya First Java", "Kathy Serria", 79},
                {"Elango Java", "Joshua Bloch", 36},
                {"Chandru Code", "Robert martin", 42},
                {"Thilaga in Java", "Bruce Eckel", 35},
        };
 
        int rowCount = 0;
         
        for (Object[] aBook : bookData) {
            Row row = sheet.createRow(++rowCount);
             
            int columnCount = 0;
             
            for (Object field : aBook) {
                Cell cell = row.createCell(++columnCount);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
             
        }
         
         
        try (FileOutputStream outputStream = new FileOutputStream("Sample.xlsx")) {
        	wbook.write(outputStream);
        }
        System.out.println("Success");
    }
	
 
}
		
	


