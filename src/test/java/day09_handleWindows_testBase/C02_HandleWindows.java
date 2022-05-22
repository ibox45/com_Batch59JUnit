package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindows {
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
        driver.quit();

    }

    @Test
    public void test01(){
        //1-amazon sayfasına gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandleDegeri=driver.getWindowHandle();
        //2-url'in amazon icerdgni test edelim
        String istenenKelime="amazon";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(istenenKelime));
        //3-yenı bır penccere acıp bestbuy ana sayfasına gıdelım
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaWindowHandleDegeri=driver.getWindowHandle();
        //4-title'in BestBuy icerdgni kontrol edin
        String istenenTitle="Best Buy";
        String actualTitle=driver.getTitle();
        Assert.assertTrue(actualTitle.contains(istenenTitle));
        //5-ilk sayfaya donüp java aratalım
        driver.switchTo().window(ilkSayfaWindowHandleDegeri);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);

        //6-arama sonuclarının Java icerdgni test edelim
        WebElement sonucYazisiElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String istenenSonucYazisi="Java";
        Assert.assertTrue(sonucYazisiElementi.getText().contains(istenenSonucYazisi));
        //7-yeniden bestbuy'in acık oldugu sayfaya gidelim
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);
        //8-logonun gorundugunu test edelim
        WebElement logoElementi=driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }

}


