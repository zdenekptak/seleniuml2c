/* nacitani dat z excelu */
package helpers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    /* definujeme si cestu kterou pouzijeme v public excelReader */
    private Workbook excelData;

    /* vytvorime konstruktor a ten bude vyzadovat jeden parametr, ktery bude klic k nasemu excelu */
    public ExcelReader(String excelPath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(excelPath));
        this.excelData = new XSSFWorkbook(fileInputStream);
    }
    public Sheet getSheetByName(String sheetName) {
        return excelData.getSheet(sheetName);
    }

}
