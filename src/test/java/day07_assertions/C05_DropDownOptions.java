package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropDownOptions {
    /*
    amazon sayfasına gidip
    dropdown menuden books'u secelım
    sectıgmız option'u yazdıralım

    dropdowndaki  opsiyonların toplam sayısının 20 oldugunu test edın
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //driver.close();
    }

    @Test
    public void Test01(){
        driver.get("https://www.amazon.com");
        WebElement dropDownMenu=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropDownMenu);
        select.selectByVisibleText("Books");

        //bir dropdown ile calısıyorken , son secılen option'a ulasmak istersenız
        //select.getFirsrSelectedOption() method'unu kullanmalısınız
        //bu method bıze WebElement döndürür.
        //uzerindekı yazıyı yazdırmak icin getText() unutulmamalıdır.
        System.out.println(select.getFirstSelectedOption().getText());

        //dropdowndaki  opsiyonların toplam sayısının 20 oldugunu test edın

        List<WebElement>optionList=select.getOptions();
        int optionSayisi=optionList.size();
        int expectedOptionsayisi=28;
        Assert.assertEquals(expectedOptionsayisi,optionSayisi);


    }
}
