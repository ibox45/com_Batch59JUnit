package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {
    @Test
    public void JSExecuterTest() throws InterruptedException {

        //amazon'a gidelim  //baska bir deneme yaptım.

        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");
        //asagıdakı sign in butonu gorununceye kadar js ile scrool yapalım

        JavascriptExecutor jse= (JavascriptExecutor) driver;




        WebElement element = driver.findElement(By.xpath(".//*[@id='mCSB_3_container']/p[3]"));

        jse.executeScript("arguments[0].scrollIntoView(true);",element);

        System.out.println(element.getText());


//sign in butonuna js ile click yapalim
       // jse.executeScript("arguments[0].click();",signInButton);





    }
}
