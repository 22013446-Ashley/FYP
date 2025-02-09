/**
 * 
 * I declare that this code was written by me, lucas. 
 * I will not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Lucas
 * Student ID: 22026220
 * Class: E63C
 * Date created: 2023-10-25, 09:01AM
 * 
 */
package FYPproject;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileInputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class excelService {

	@Autowired
	private excelDataRepository excelDataRepository;

	public void saveExcelData(String filePath) throws Exception {
		List<merchantExcel> merchants = new ArrayList<>();

		File file = new File(filePath); // convert path to file object

		try (InputStream inputStream = new FileInputStream(file); Workbook workbook = new XSSFWorkbook(inputStream)) {

			Sheet sheet = workbook.getSheetAt(0); // first sheet
			Iterator<Row> rows = sheet.iterator();

			// Skip header
			if (rows.hasNext())
				rows.next();

			while (rows.hasNext()) {
				Row row = rows.next();

				String custNameTX = getStringCellValue(row, 2);
				String tradingName = getStringCellValue(row, 3);
				String ctcName = getStringCellValue(row, 4);
				String phoneNum = getStringCellValue(row, 5);
				String email = getStringCellValue(row, 6);

				merchantExcel merchant = new merchantExcel(custNameTX, tradingName, ctcName, phoneNum, email);
				merchants.add(merchant);
				System.out.println(merchant);

				excelDataRepository.save(merchant);
			}
		}

		System.out.println(merchants);

		// Save all data to the database
		// excelDataRepository.save(merchants);
		System.out.println("Data saved to the database successfully!");
	}

	private String getStringCellValue(Row row, int columnIndex) {
		Cell cell = row.getCell(columnIndex);

		if (cell == null) {
			return ""; // If the cell is empty, return an empty string.
		}

		// Check the cell type and extract value accordingly.
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			// Check if the numeric value is a date
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue().toString(); // Handle dates if needed
			} else {
				return String.valueOf(cell.getNumericCellValue()); // For numbers, convert to string
			}
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return cell.getCellFormula(); // If the cell has a formula
		default:
			return ""; // Default for other types
		}
	}

}