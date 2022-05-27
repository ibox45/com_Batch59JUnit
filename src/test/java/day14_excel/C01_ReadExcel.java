package day14_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    //1. apache poi dependency’i pom file’a ekleyelim
    //2. Java klasoru altinda
    //resources klasoru olusturalim
    //3. Excel dosyamizi resources klasorune ekleyelim
    //4. excelAutomation
    //isminde bir package olusturalim
    //5. ReadExcel isminde bir class olusturalim
    //6. readExcel() method olusturalim

    @Test
    public void readExcelTest() throws IOException {

        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10.WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);
        //11. Sheet objesi olusturun workbook.getSheetAt(index)
        Sheet sheet= workbook.getSheet("Sayfa1");
        //12. Row objesi olusturun sheet.getRow(index)
        Row row=sheet.getRow(3);
        //13. Cell objesi olusturun row.getCell(index)
        Cell cell=row.getCell(3);
        System.out.println(cell);

        //3. indexdeki satirin 3. indexdeki datanın Cezayir oldugunu test edin

        String expected="Cezayir";
        String actual=cell.toString();
        //String actual=cell.getStringCellValue();  bu da olur.

        Assert.assertEquals(expected,actual);

    }
}
