package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    // Bir Class olusturalim YanlisEmailTesti
    //http://automationpractice.com/index.php sayfasina gidelim
    //Sign in butonuna basalim
    //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
    //   “Invalid email address” uyarisi ciktigini test edelim

    @Test

    public void test01(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//a[@class='login']")).click();
        driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("etisaretiyok"+ Keys.ENTER);
        WebElement uyariYazisiElementi=driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(uyariYazisiElementi.isDisplayed());

        driver.close();




    }
}
