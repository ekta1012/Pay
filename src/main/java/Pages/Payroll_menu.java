package Pages;


import Utility.utility_methods;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;





public class Payroll_menu {

    WebDriver driver;
    String arrName1;

    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;
    public static String w;
    //   public String arrName1;
    public static List<String> arrName;


    public static List<String> Excel() throws IOException {

        try {

            FileInputStream ExcelFile = new FileInputStream("C:\\Ashwini\\TestingStuff\\pay\\Pay\\src\\main\\java\\TestData\\Menu.xlsx");

            ExcelWBook = new XSSFWorkbook(ExcelFile);

            ExcelWSheet = ExcelWBook.getSheet("Sheet1");
            //  int a=ExcelWSheet.getFirstRowNum();
            // int a=ExcelWSheet.getLastRowNum();


            int a = ExcelWSheet.getPhysicalNumberOfRows();
            System.out.println("Total rows in Excel is " + a + "  " + "and Menu's are following:");

            // Sheet ExcelWSheet = ExcelWBook.getSheet("Sheet1");

            int rowCount = ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();

            arrName = new ArrayList<String>();
            for (int i = 0; i < rowCount + 1; i++) {

                Row row = ExcelWSheet.getRow(i);


                //Create a loop to print cell values in a row

                for (int j = 0; j < row.getLastCellNum(); j++) {

                    //Print Excel data in console

                    //w= row.getCell(j).getStringCellValue();
                    //System.out.print(row.getCell(j).getStringCellValue() + "\n");
                    arrName.add(row.getCell(j).getStringCellValue());
//                    for (String arrName1 : arrName) {
//
//                    }
                }

            }

        } catch (Exception e) {
            System.out.println("" + e);
        }
        return arrName;

    }


}











