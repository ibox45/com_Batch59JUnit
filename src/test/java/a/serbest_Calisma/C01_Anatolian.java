package a.serbest_Calisma;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Anatolian {

    //bir alişveris sitesi olan https://www.anatolianinternational.com/tr adresine gidip alışveriş yapacagız.

    @Test
    public void test01() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.anatolianinternational.com/tr");

        //giriş yap butonuna tıkla
        WebElement loginElementi=driver.findElement(By.xpath("(//i[@class='feather icon-user'])[2]"));
        loginElementi.click();
        //Thread.sleep(3000);
        WebElement loginButtonElementi=driver.findElement(By.xpath("//div[@class='shopperLoginBtn']"));
        loginButtonElementi.click();
        //Thread.sleep(3000);

        //e posta ve şifre gir
        WebElement ePostaElementi=driver.findElement(By.xpath("//input[@id='login_email']"));
        ePostaElementi.sendKeys("TR93476041");
        //Thread.sleep(3000);
        WebElement passwordElementi=driver.findElement(By.xpath("//input[@id='login_password']"));
        passwordElementi.sendKeys("1234"+ Keys.ENTER);
        Thread.sleep(3000);


      // gida takviyesine tıkla ,ozonhapına tıkla ve 2 adet ozon hapını sepete ekle alisverise devat et butonuna bas
      WebElement gidaTakviyesiElementi= driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/div/div[3]/div/ul/li[1]/a"));
       gidaTakviyesiElementi.click();
        Thread.sleep(3000);
       WebElement ozonHapiElementi=driver.findElement(By.xpath("//img[@alt='CENTOZONE']"));
      ozonHapiElementi.click();
        Thread.sleep(3000);
      WebElement plusElemeti=driver.findElement(By.id("quantity_inc_button"));
      plusElemeti.click();
        Thread.sleep(3000);
      WebElement sepeteEkleElementi=driver.findElement(By.id("addToCart"));
      sepeteEkleElementi.click();
        Thread.sleep(3000);
      WebElement alisVeriseDevamEtElementi=driver.findElement((By.xpath("/html/body/div[7]/div/button[2]")));
      alisVeriseDevamEtElementi.click();
       Thread.sleep(3000);

       //kisisel bakıma tıkla 1 adet Cosmozone Anti-Aging Krem sepete ekle ve sepete git butonuna bas ve sepeti onayla
        WebElement kisiselBakimElemeti=driver.findElement(By.xpath("/html/body/div[2]/header/div[2]/div/div/div[3]/div/ul/li[3]/a"));
        kisiselBakimElemeti.click();
        Thread.sleep(3000);
        WebElement sepeteEkle2Elementi=driver.findElement(By.xpath("(//button[@class='btn btn-success btn-block'])[2]"));
        sepeteEkle2Elementi.click();
        Thread.sleep(3000);
        WebElement sepeteGitElementi=driver.findElement(By.xpath("(//button[@type='button'])[10]"));
        sepeteGitElementi.click();
        Thread.sleep(3000);
        WebElement sepetiOnaylaElementi=driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        sepetiOnaylaElementi.click();
        Thread.sleep(3000);

        WebElement urunleriKendimElementi=driver.findElement(By.xpath("//*[@id=\"selectOpt\"]/center/button[1]"));
        urunleriKendimElementi.click();
       Thread.sleep(3000);

        WebElement adresElementi=driver.findElement(By.xpath("(//div[@class='address-single-content'])[1]"));
        adresElementi.click();
        Thread.sleep(3000);

        WebElement krediKartiSecimElementi=driver.findElement(By.xpath("//label[@for='payment_kuveytturk']"));
        krediKartiSecimElementi.click();
        Thread.sleep(3000);

        WebElement odemeyeGecElementi=driver.findElement(By.id("go_pay"));
        odemeyeGecElementi.click();
        Thread.sleep(3000);

        WebElement kartNoElementi=driver.findElement(By.xpath("//input[@id='number']"));
        kartNoElementi.sendKeys("1234567891234567");
        Thread.sleep(3000);
        WebElement isimSoyisimElementi=driver.findElement(By.xpath("//input[@id='name']"));
        isimSoyisimElementi.sendKeys("ibrahim Akdeniz");
        Thread.sleep(3000);
        WebElement ayYilElementi=driver.findElement(By.xpath("//input[@id='expiry']"));
        ayYilElementi.sendKeys("1126");
        Thread.sleep(3000);
        WebElement cvcElementi=driver.findElement(By.xpath("//input[@id='cvc']"));
        cvcElementi.sendKeys("123");
        Thread.sleep(3000);
        WebElement odemeYapElementi=driver.findElement(By.xpath("//button[@onclick='cardPost()']"));
        odemeYapElementi.click();
        //Thread.sleep(3000);

















    }


}
