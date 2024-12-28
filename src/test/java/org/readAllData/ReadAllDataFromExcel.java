package org.readAllData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAllDataFromExcel {
	
	static File file;
	static FileInputStream inputStream;
	static Workbook wb;
	static Sheet sheet;
	static Row row;
	static Cell cell;
	static DataFormatter formatter;
	static int i,j;
	static String values;

	public static void main(String[] args) throws IOException {
		file = new File(".\\Excel\\KumaranEx5.xlsx");
		inputStream = new FileInputStream(file);
		wb = new XSSFWorkbook(inputStream);
		sheet = wb.getSheet("ALLDATA");
		
		int numberOfRows = sheet.getPhysicalNumberOfRows();
		for(int i=0; i<numberOfRows; i++) {
			int numberOfCells = sheet.getRow(i).getPhysicalNumberOfCells();
			for(int j=0; j<numberOfCells; j++) {
				row = sheet.getRow(i);
				cell = row.getCell(j);
				formatter = new DataFormatter();
				values = formatter.formatCellValue(cell);
				System.out.print(values+"|");
			}
			System.out.println();
		}
	}
}
