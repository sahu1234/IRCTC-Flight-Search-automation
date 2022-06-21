package com.irctcflightsearchautomation.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelDataFile {

	public static void main(String[] args) {

		// Blank workbook
		XSSFWorkbook workbook = new XSSFWorkbook();

		// Create Excel Sheet
		XSSFSheet samplesheet = workbook.createSheet("No of Flights");

		// Creating the Data
		Map<String, Object[]> dataSet = new TreeMap<String, Object[]>();
		dataSet.put("1", new Object[] { "ID", "NAME", "Number of Flight" });
		dataSet.put("2", new Object[] { "1", "Air India", "AI-541/851" });
		dataSet.put("3", new Object[] { "2", "Air India", "AI-541/849" });
		dataSet.put("4", new Object[] { "3", "Air India", "AI-840/851" });
		dataSet.put("5", new Object[] { "4", "Air India", "AI-840/849" });
		dataSet.put("6", new Object[] { "5", "Air India", "AI-698/806/849" });
		dataSet.put("7", new Object[] { "6", "Air India", "AI-698/864/849" });
		dataSet.put("8", new Object[] { "7", "Air India", "AI-698/635/849" });
		dataSet.put("9", new Object[] { "8", "Vistara", "UK-890/931" });
		dataSet.put("10", new Object[] { "9", "Vistara", "UK-890/991" });
		dataSet.put("11", new Object[] { "10", "Vistara", "UK-890/973" });
		dataSet.put("12", new Object[] { "11", "Vistara", "UK-870/931" });
		dataSet.put("13", new Object[] { "12", "Vistara", "UK-870/991" });
		dataSet.put("14", new Object[] { "13", "Vistara", "UK-870/973" });
		dataSet.put("15", new Object[] { "14", "Vistara", "UK-876/970/931" });
		dataSet.put("16", new Object[] { "15", "Vistara", "UK-876/994/931" });
		dataSet.put("17", new Object[] { "16", "Vistara", "UK-876/930/931" });
		dataSet.put("18", new Object[] { "17", "Vistara", "UK-876/930/991" });

		// Iterate over the Data
		Set<String> set = dataSet.keySet();
		int rownum = 0;

		for (String key : set) {

			Row row = samplesheet.createRow(rownum++);

			Object[] data = dataSet.get(key);

			int cellNum = 0;

			for (Object value : data) {

				Cell cell = row.createCell(cellNum++);

				if (value instanceof String)
					cell.setCellValue((String) value);
				else if (value instanceof Integer)
					cell.setCellValue((Integer) value);

			}

		}

		// Write Down file on HadDisk
		try {
			FileOutputStream writeFile = new FileOutputStream("No of Flights.xlsx");
			// For MacUsers /users/customDir Name/FileName
			// For Windows C:/Test/Sample/..../Filename
			// C://Test//Sample//....//filename

			workbook.write(writeFile);

			writeFile.close();
			System.out.println("No of Flights Excel file is being created Successfully");

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
