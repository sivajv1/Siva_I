import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadAnWriteDate {

	public static void main(String[] args) {
		try {
			List<Student> studentList = readDataFromExcel("C:\\Users\\sivaj\\eclipse-workspace\\Selepract\\file.xlsx");
			displayData(studentList);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static List<Student> readDataFromExcel(String filePath) throws IOException {
		List<Student> studentList = new ArrayList<>();
		try (FileInputStream file = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(file)) {
			XSSFSheet sheet = workbook.getSheetAt(0); // Assuming data is in the first sheet
			for (Row row : sheet) {
				Cell nameCell = row.getCell(0);
				Cell courseCell = row.getCell(1);
				Cell feeCell = row.getCell(2);
				if (row.getRowNum() == 0) {
					continue;
				}
				Student student = new Student(nameCell.getStringCellValue(), courseCell.getStringCellValue(),
						feeCell.getStringCellValue());
				studentList.add(student);
			}
		}

		return studentList;
	}

	private static void displayData(List<Student> studentList) {
		System.out.println("Name\t\tCourses\t\tFee");
		System.out.println("-----------------------------------");
		for (Student student : studentList) {
			System.out.println(student.getName() + "\t\t" + student.getCourses() + "\t\t" + student.getFee());
		}
	}

	private static class Student {
		private String name;
		private String courses;
		private String fee;

		public Student(String name, String courses, String fee) {
			this.name = name;
			this.courses = courses;
			this.fee = fee;
		}

		public String getName() {
			return name;
		}

		public String getCourses() {
			return courses;
		}

		public String getFee() {
			return fee;
		}
	}
}
