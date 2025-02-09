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
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelExtractor {
    public static void main(String[] args) {
        // Define file paths for the Excel files
        String[] filePaths = {
            "Database_Sample.xlsx",
            "ACRA Database.xlsx"
        };

        // Process each file
        for (String filePath : filePaths) {
            System.out.println("Processing file: " + filePath);

            try (FileInputStream fis = new FileInputStream(new File(filePath))) {
                Workbook workbook = null;

                // Check file extension and load the correct Workbook class
                if (filePath.endsWith(".xlsx")) {
                    workbook = new XSSFWorkbook(fis); // For .xlsx files
                } else if (filePath.endsWith(".xls")) {
                    workbook = new HSSFWorkbook(fis); // For .xls files
                } else {
                    System.out.println("Invalid Excel file format: " + filePath);
                    continue;
                }

                // Get the first sheet
                Sheet sheet = workbook.getSheetAt(0);

                // Iterate through rows and cells to extract data
                for (Row row : sheet) {
                    for (Cell cell : row) {
                        switch (cell.getCellType()) {
                            case STRING:
                                System.out.print(cell.getStringCellValue() + "\t");
                                break;
                            case NUMERIC:
                                System.out.print(cell.getNumericCellValue() + "\t");
                                break;
                            case BOOLEAN:
                                System.out.print(cell.getBooleanCellValue() + "\t");
                                break;
                            default:
                                System.out.print("UNKNOWN\t");
                        }
                    }
                    System.out.println();
                }

                workbook.close(); // Close the workbook
            } catch (IOException e) {
                System.err.println("Error processing file: " + filePath);
                e.printStackTrace();
            }
        }
    }
}