package org.readTheSingleData;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadTheSingleData {
	static File file;
	static FileInputStream inputStream;
	static Workbook wb;
	static Sheet sheet;
	static Row row;
	static Cell cell;
	static DataFormatter formatter;
	

	public static void main(String[] args) throws IOException {
		
		file = new File(".\\Excel\\KumaranEx5.xlsx");
		inputStream = new FileInputStream(file);
		wb = new XSSFWorkbook(inputStream);
		sheet = wb.getSheet("ALLDATA");
		
		row = sheet.getRow(0);
		cell = row.getCell(0);
		formatter = new DataFormatter();
		String value = formatter.formatCellValue(cell);
		System.out.println(value);
		
	
	}
}
