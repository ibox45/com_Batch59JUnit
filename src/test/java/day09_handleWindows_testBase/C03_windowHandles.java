package day09_handleWindows_testBase;

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
import java.util.Set;

public class C03_windowHandles {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        //driver.quit();
    }

    @Test
    public void test01() {


        // ● Tests package’inda yeni bir class olusturun: WindowHandle2
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");

        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement textElementi=driver.findElement(By.xpath("//h3"));
        String textElementiYazisi=textElementi.getText();
        String istenenText="Opening a new window";
        Assert.assertEquals(textElementiYazisi,istenenText);

        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle=driver.getTitle();
        String istenenTitle="The Internet";
        Assert.assertEquals(actualTitle,istenenTitle);


    /*
    eger kontrolsuz acilan bir tab veya window varsa
    o zaman sayfalarin window handle degerlerini elde etmem gerekir.
    oncelikle 2.sayfa acilmadan once
    ilk sayfanin window handle degerini bir String'e atayalim
     */
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        System.out.println(ilkSayfaWindowHandleDegeri);


        //● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[.='Click Here']")).click();

        /*
          switchTo().newWindow() demeden link tiklayarak yeni tab veya window olustugunda
          biz driver'a yeni sayfaya gec demedikce, driver eski sayfada kalir
          ve yeni sayfa ile ilgili hicbir islem yapamaz
          yeni sayfada driver'i calistirmak isterseniz
          once driver'i yeni sayfaya yollamalisiniz
            */

        /*
    yeni sayfaya gecebilmek icin oncelikle ikinciSayfaWindowHandleDegeri'ni bulmamiz gerekir
    bunun icin driver.getWindowHandles() method'unu kullanarak
    acik olan tum sayfalarin window handle degerlerini alip bir set'e assign ederiz.
    ilk sayfanin window handle degerini zaten biliyoruz
    Set'deki window handle degerlerini kontrol edip
    ilk sayfanin handle degerine esit olmayan
    ikinci sayfanin window handle degeridir, deriz
     */


        Set<String> windowHandleSeti= driver.getWindowHandles();
        System.out.println(windowHandleSeti);

        String ikinciSayfaWindowHandleDegeri="";
        for (String each:windowHandleSeti
             ) {
            if(!each.equals(ilkSayfaWindowHandleDegeri)){
               // String ikinciSayfaWindowHandleDegeri=each;
                ikinciSayfaWindowHandleDegeri=each;
            }

        }



        // artik ikinci sayfanin window handle degerini biliyoruz
        // rahatlikla sayfalar arasii gecis yapabiliriz
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String expectedTitle="New Window";
        String actualIkinciSayfaTitle=driver.getTitle();
        Assert.assertEquals(expectedTitle,actualIkinciSayfaTitle);
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement ikinciSayfaElementi=driver.findElement(By.xpath("//h3"));
        Assert.assertEquals("New Window",ikinciSayfaElementi.getText());


        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        String ilkSayfaTitle=driver.getTitle();
        Assert.assertEquals("The Internet",ilkSayfaTitle);



    }

}


