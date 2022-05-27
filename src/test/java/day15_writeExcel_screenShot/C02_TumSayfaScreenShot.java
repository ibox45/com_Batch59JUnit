package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class C02_TumSayfaScreenShot extends TestBase {
    @Test
    public void TumSayfa() throws IOException {
        //amazon sayfasına gidip tum sayfanın fotografını cekelim
        driver.get("https://www.amazon.com");

        TakesScreenshot ts= (TakesScreenshot) driver;

        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String tarih=date.format(dtf);

        File tumSayfaResim=new File("target/ekranGoruntuleri/tumSayfa"+tarih+".jpeg");

        File geciciDosya=ts.getScreenshotAs(OutputType.FILE);


        FileUtils.copyFile(geciciDosya,tumSayfaResim);


    }
}
