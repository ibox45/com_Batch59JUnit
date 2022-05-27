package day14_excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ReadExcel {


    @Test
    public void ReadExcelTest() throws IOException {
        //excel dosyasındaki tum verileri classımıza alıp
        //bir java objesıne store edelim
        //boylece herseferınde excel'e ulasıp satır ,sutun vs. ugrasmayalım
        //Database yapısında olan excel'i koyabilecegimiz en uygun Java objesi map'tir.

        Map<String,String> ulkelerMap=new HashMap<>();
        //7. Dosya yolunu bir String degiskene atayalim
        String dosyaYolu="src/resources/ulkeler.xlsx";
        //8. FileInputStream objesi olusturup,parametre olarak dosya yolunu girelim
        FileInputStream fis=new FileInputStream(dosyaYolu);
        //9. Workbook objesi olusturalim,parameter olarak fileInputStream objesini girelim
        //10.WorkbookFactory.create(fileInputStream)
        Workbook workbook= WorkbookFactory.create(fis);

        int sonSatirIndex=workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <=sonSatirIndex ; i++) {
            //key i. satırdaki 0 indexindeki data olacak
            String key=workbook.getSheet("Sayfa1").getRow(i).getCell(0).toString();

            //value ise i. satırdaki 1,2,3. indexdeki dataların birleşimi olacak
            String value=workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();
            ulkelerMap.put(key,value);
            System.out.println(key+" , "+ value);



        }
        System.out.println(ulkelerMap);

        //Listede Ghana oldugunu test edelim.

        Assert.assertTrue(ulkelerMap.keySet().contains("Ghana"));


    }
}
