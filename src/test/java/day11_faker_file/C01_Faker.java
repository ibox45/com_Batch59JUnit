package day11_faker_file;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void Test01()  {
        //facebook ana sayfaya gidip
        //yenı kayıt olustura basalım
        //ısım kutusunu locate edip
        //gerıye kalan alanları TAB ile dolasarak
        //formu doldurun

        driver.get("https://wwww.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement firstNameElementi=driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions=new Actions(driver);
        Faker faker=new Faker();
        String fakeMail=faker.internet().emailAddress();

        actions.click(firstNameElementi)
                .sendKeys(faker.name().firstName()+ Keys.TAB)
                .sendKeys(faker.name().lastName()).sendKeys(Keys.TAB)
                .sendKeys(fakeMail).sendKeys(Keys.TAB)
                .sendKeys(fakeMail).sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password()).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys("05").sendKeys(Keys.TAB)
                .sendKeys("Şub").sendKeys(Keys.TAB)
                .sendKeys("1984").sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.RIGHT).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER).perform();
    }
}
