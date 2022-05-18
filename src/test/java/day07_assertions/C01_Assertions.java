package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    /*
    amazon ana sayfaya gidin
    3 farklı test methodu olusturarak asagıdakı gorevlerı yapın
    1-url'in amazon içerdigini test edin
    2- title'in facebook içermedigini test edin
    3-sol ust kosede amazon logosunun gorundugunu test edin
     */
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass
    public static void tearDown(){
       driver.close();
    }
    @Test
    public void test01() {
       //driver.get("https://www.amazon.com");  beforeClass'a aldim
        //1-url'in amazon içerdigini test edin
        String arananKelime = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(arananKelime));

    }
    @Test
    public void test02(){
        //2- title'in facebook içermedigini test edin
        String istenmeyenKelime = "facebook";
        String actualTitle=driver.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));

    }
    @Test
    public void test03(){
        //3-sol ust kosede amazon logosunun gorundugunu test edin
        WebElement amazonLogo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(amazonLogo.isDisplayed());


    }

}
