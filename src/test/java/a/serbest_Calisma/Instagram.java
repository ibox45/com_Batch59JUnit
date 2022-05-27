package a.serbest_Calisma;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Instagram extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.instagram.com/");
        String instagramSayfasiWindowHandleDegeri=driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://mail.tm/tr/");
        String mailtmWindowsHandleDegeri=driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@type='email']")).click();
        driver.switchTo().window(instagramSayfasiWindowHandleDegeri);
        WebElement kaydolElementi=driver.findElement(By.xpath("//*[text()='Kaydol']"));
        kaydolElementi.click();
        WebElement epostaElementi=driver.findElement(By.name("emailOrPhone"));
        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        actions.click(epostaElementi)
                .keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).sendKeys(Keys.TAB)
                .sendKeys(faker.name().fullName()).sendKeys(Keys.TAB).perform();
        Thread.sleep(1000);
        WebElement refreshButonu=driver.findElement(By.xpath("//span[@class='coreSpriteInputRefresh Szr5J']"));
        actions.click(refreshButonu)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.ENTER).perform();



        WebElement ddm=driver.findElement(By.xpath("//select[@title='Yıl:']"));
        Select select=new Select(ddm);
        select.selectByVisibleText("2003");
        driver.findElement(By.xpath("//button[text()='İleri']")).click();
        driver.switchTo().window(mailtmWindowsHandleDegeri);
        Thread.sleep(15000);
        driver.findElement(By.xpath("(//img[@alt='Avatar'])[2]")).click();
        Thread.sleep(3000);
        WebElement codeElementi=driver.findElement(By.xpath("//*[@id=\"email_content\"]/table/tbody/tr[4]/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/table/tbody/tr[2]"));
        String codeElementiYazisi=codeElementi.getText();
        driver.switchTo().window(instagramSayfasiWindowHandleDegeri);
        WebElement onayKoduKutusu=driver.findElement(By.xpath("//input[@aria-label='Onay Kodu']"));
        actions.click(onayKoduKutusu)
                .sendKeys(codeElementiYazisi).perform();


















    }
}
