package a.serbest_Calisma;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Challange extends TestBase {



    @Test
    public void test01() throws InterruptedException {

        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");


        //2. Username kutusuna "standard_user" yazdirin
        //3. Password kutusuna "secret_sauce" yazdirin
        //4. Login tusuna basin
        WebElement usernameKutusu=driver.findElement(By.id("user-name"));
        Actions actions =new Actions(driver);
        actions.click(usernameKutusu)
                .sendKeys("standard_user")
                .sendKeys(Keys.TAB)
                .sendKeys("secret_sauce")
                .sendKeys(Keys.ENTER).perform();



        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement ilkUrunIsmiElementi=driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String ilkUrunIsmiElementiYazisi=ilkUrunIsmiElementi.getText();
        ilkUrunIsmiElementi.click();
        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();
        //7. Alisveris sepetine tiklayin
        driver.findElement(By.className("shopping_cart_link")).click();
        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        Assert.assertTrue(driver.findElement(By.className("inventory_item_name")).isDisplayed());
        //9. Sayfayi kapatin
        driver.close();


    }
}
