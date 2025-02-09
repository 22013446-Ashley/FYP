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

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook; 
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.DateUtil;


@Entity
@Table(name = "excel_info")
public class merchantExcel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String custNameTX;
	private String tradingName;
	private String ctcName;
	private String phoneNum;
	private String email;

	// Contructor of merchant class
	public merchantExcel() {
	}

	// Method 1
	@Override
	public String toString() {
		return String.format("%s, %s, %s, %s, %s", custNameTX, tradingName, ctcName, phoneNum, email);
	}

	public merchantExcel(String custNameTX, String tradingName, String ctcName, String phoneNum, String email) {
		this.custNameTX = custNameTX;
		this.tradingName = tradingName;
		this.ctcName = ctcName;
		this.phoneNum = phoneNum;
		this.email = email;
	}

	// Method 2: get name of merchant
	public String getCustNameTX() {
		return custNameTX;
	}

	public void setCustNameTX(String custNameTX) {
		this.custNameTX = custNameTX;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public String getCtcName() {
		return ctcName;
	}

	public void setCtcName(String ctcName) {
		this.ctcName = ctcName;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isApproved() {
		return false;
	}

	// class to assign the cell value once it is getting done to
	// read from excel sheet It can be String/Boolean/Numeric
	public static class GetDataFromExcel {
		private Object getCellValue(Cell cell) {
			switch (cell.getCellType()) {
			case STRING:
				return cell.getStringCellValue();
			case BOOLEAN:
				return cell.getBooleanCellValue();
			case NUMERIC:
				if (DateUtil.isCellDateFormatted(cell)) {
					return cell.getDateCellValue();
				} else {
					return cell.getNumericCellValue();
				}
			default:
				return null;
			}
		}

		// Read the excel sheet contents and get the contents in
		// a list
		public List<merchantExcel> readBooksFromExcelFile(String excelFilePath) throws IOException {
			List<merchantExcel> listMerchantExcel = new ArrayList<>();

			try (FileInputStream inputStream = new FileInputStream(new File(excelFilePath));
					Workbook workbook = new XSSFWorkbook(inputStream)) {

				Sheet firstSheet = workbook.getSheetAt(0);
				Iterator<Row> iterator = firstSheet.iterator();

				// Skip the header row (optional)
				if (iterator.hasNext()) {
					iterator.next();
				}

				while (iterator.hasNext()) {
					Row nextRow = iterator.next();
					Iterator<Cell> cellIterator = nextRow.cellIterator();
					merchantExcel mercEx = new merchantExcel();

					while (cellIterator.hasNext()) {
						Cell nextCell =

								cellIterator.next();
						int columnIndex = nextCell.getColumnIndex();

						try {
							switch (columnIndex) {
							case 0:
								mercEx.setCustNameTX((String) getCellValue(nextCell));
								break;
							case 1:
								mercEx.setTradingName((String) getCellValue(nextCell));
								break;
							case 2:
								mercEx.setCtcName((String) getCellValue(nextCell));
								break;
							case 3:
								mercEx.setPhoneNum((String) getCellValue(nextCell));
								break;
							case 4:
								mercEx.setEmail((String) getCellValue(nextCell));
								break;
							}
						} catch (Exception e) {
							System.err.println("Error reading cell at column: " + columnIndex);
						}
					}

					// Only add valid rows
					if (mercEx.getCustNameTX() != null && !mercEx.getCustNameTX().isEmpty()) {
						listMerchantExcel.add(mercEx);
					}
				}
			}

			return listMerchantExcel;
		}

	}

}
