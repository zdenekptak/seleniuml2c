package helpers;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReaderSecond {
    /* použijeme main metodu - je to metoda kterou můžu okamžite spustit*/
    /* public static void - znamená že nic nevrací */
    public static void main(String[] args) throws IOException {
        /* nacteme file pomoci FileInputStream */
        FileInputStream fileInputStream = new FileInputStream(new File("src/test/resources/data.xlsx"));
        /* potrebujeme rict ze je to excel soubor - stahneme si proto dalsi knihovnu Apache POI */
        /* vytvorime workbook - XSSFWorkbook precte nas soubor data.xlsx*/
        Workbook excelData = new XSSFWorkbook(fileInputStream);

        /* Nacteni konkretniho sheetu v excelu */
        Sheet sheet = excelData.getSheetAt(0);
        /* Nacteni konkretniho radky v excelu */
        Row row = sheet.getRow(0);
        /* tiskneme prvni bunku na radku a pomoci .getStringCellValue() ziskame jeji string hodnotu */
        System.out.println(row.getCell(1).getStringCellValue());

    }





}
