package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {

    @Test
    public void test01()  {
        // 1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(driver);
        WebElement cizgiliAlanElementi= driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiliAlanElementi).perform();


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //    test edelim.
        String expectedYazi="You selected a context menu";
        String actualYazi=driver.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        Set<String> sayfalarSeti=driver.getWindowHandles();
        String ikinciSayfaWindowHandleDegeri="";
        for (String each:sayfalarSeti
             ) {if(!each.equals(ilkSayfaWindowHandleDegeri)){
                 ikinciSayfaWindowHandleDegeri=each;}

        }
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        WebElement h1TagiElementi=driver.findElement(By.xpath("//h1"));
        String actualh1TagiYazisi=h1TagiElementi.getText();
        String expectedh1TagiYazisi="Elemental Selenium";
        Assert.assertEquals(expectedh1TagiYazisi,actualh1TagiYazisi);

        }




    }



