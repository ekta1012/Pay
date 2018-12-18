package Pages;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import static Pages.Master_Settings.Global_link;
import static Utility.utility_methods.find_allLinksTitle;


public class Payroll_menu {
    private static XSSFSheet ExcelWSheet;
    private static XSSFWorkbook ExcelWBook;
    private static XSSFCell Cell;

    public static void main(String args[]) throws Exception {


        FileInputStream ExcelFile = new FileInputStream("C:\\Users\\abc\\IdeaProjects\\Pay\\src\\main\\java\\Testdata\\Menu_Excel.xlsx");

        ExcelWBook = new XSSFWorkbook(ExcelFile);

        ExcelWSheet = ExcelWBook.getSheet("Sheet1");
        //  int a=ExcelWSheet.getFirstRowNum();
        // int a=ExcelWSheet.getLastRowNum();


        int a = ExcelWSheet.getPhysicalNumberOfRows();
        System.out.println("Total rows in Excel is " + a + "  " + "and Menu's are following:");

        Sheet ExcelWSheet = ExcelWBook.getSheet("Sheet1");

        int rowCount = ExcelWSheet.getLastRowNum() - ExcelWSheet.getFirstRowNum();

        for (int i = 0; i < rowCount + 1; i++) {

            Row row = ExcelWSheet.getRow(i);

            //Create a loop to print cell values in a row

            for (int j = 0; j < row.getLastCellNum(); j++) {

                //Print Excel data in console

                System.out.print(row.getCell(j).getStringCellValue() + "\n");

            }

            System.out.println();
        }
        try{
          //  List<String> name=find_allLinksTitle(Global_link);
        }
        catch(Exception e)
        {

        }
    }


}