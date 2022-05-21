package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
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
        driver.quit();
    }
    @Test
    public void test01(){

        //1-amazon ana sayfaya gidin

        driver.get("https://www.amazon.com");
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        //2-nutella icin arama yaptırın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);


        /*
        CDwindow-4D2E9742C323FED0B9E11695AD4ECA36
        bu kod acılan sayfanın unique hash kodudur.
        Selenium sayfalar arası gecıste bu window handle degerını kullanır

        eger sayfalar arasında driverlarımızı gezdırıyorsak ve herhangı bir sayfadan
        suanda bulundugumuz sayfaya gecmek ıstıyorsak
        driver.switchTo().window("CDwindow-C831B857B681177A821A59CE74AB51F0");
        bu sayfanın window handle degerını girerek bu sayfaya gecisi saglayabılırız.
         */

        //3-ilk urunun resmını tıklayarak farklı bir tab olarak acın
        WebElement ilkUrunResmi=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*
        Bu komutu kullandıgımızda drıver otomatik olarak olusturulan new Tab'a gecer
        yeni Tab'da gorevi gerceklestirmek icin adımları bastan almamız gerekır.
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();

        //4- yeni tabda acılan urunun  basligini yazdırın
        WebElement urunTitleElementi=driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitleElementi.getText());


        //ilk sayfaya gecip url'i yazdıralım.
        driver.switchTo().window(ilkSayfaHandleDegeri);
        System.out.println(driver.getCurrentUrl());


    }
}
