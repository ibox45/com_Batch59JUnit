package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeywordActions extends TestBase {

    @Test
    public void test01() {
        //facebook ana sayfaya gidip
        //yenı kayıt olustura basalım
        //ısım kutusunu locate edip
        //gerıye kalan alanları TAB ile dolasarak
        //formu doldurun

        driver.get("https://wwww.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement firstNameElementi=driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions=new Actions(driver);
        actions.sendKeys("ibrahim"+Keys.TAB)
                .sendKeys("akdeniz").sendKeys(Keys.TAB)
                .sendKeys("ibrahimakdeniz@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("ibrahimakdeniz@gmail.com").sendKeys(Keys.TAB)
                .sendKeys("1234").perform();




    }
}
