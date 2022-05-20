package day08_alerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown(){
        //driver.quit();
    }

    @Test
    public void test01(){
        /*herhangi bir web sitesine gidince veya
        bir websitesinde herhangi bir islem yaptıgımızda ortaya cıkan uyarılara alert diyoruz

        eğer bir alert inspect yapılabılıyorsa o alert otomasyon ıle kullanılabılır.
        bu tur alert'lere HTML alert denır ve bunlar ıcın ekstra bır ıslem yapmaa gerek yoktur
        tum web elementler gıbı locate edıp ıstedgmız ıslemlerı yapabılırız
        driver.get("https://www.teknosa.com"); da çıkan alert vb..

        Ancak web uygulamalrında HTML alert yanında java script alert de bulunabılır
        js alertler lacate edılemez
        selenium'da JS alertler icin ozel bir yontem gelıstırmıstir
         */

       driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //alert'te OK tusuna basın
       driver.switchTo().alert().accept();

       //result kısmında "You successfully clicked an alert" yazdıgını test edin

        String expectedResult="You successfully clicked an alert";
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResultYazisi=sonucYaziElementi.getText();

        Assert.assertEquals(expectedResult,actualResultYazisi);









    }




}
