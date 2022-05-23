package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {





    @Test
    public void test01() throws InterruptedException {
        //1. Tests packagenin altina bir class oluşturalim
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. dummy.txt dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='dummy.txt']")).click();
        Thread.sleep(5000);
        //4. dosyanın başarıyla indirilip indirilmediğini test edelim
        //dosya downloads'a indirilecek downloads'ın yolu lazım.

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Downloads\\dummy.txt";
        String arananDosyaYolu=farkliKisim+ortakKisim;

        //geriye o dosya yolunda dosyanın varolup olmadgnı assesrt edelim.

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));


    }
}
