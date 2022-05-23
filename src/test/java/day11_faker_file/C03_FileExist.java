package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {
        System.out.println(System.getProperty("user.dir"));
        //Bana icinde oldugum projenin dosya yolunu(path) veriyor.
        System.out.println(System.getProperty("user.home"));
        //C:\Users\ibox4 yani bilgisayarımın bana ozel kısmını verdi.

        //"C:\Users\ibox4\Downloads"
        //"C:\Users\ibox4\Desktop"

        //homePath+ "/Downloads"

        //masaustumuzdeki text dosyasının varlıgını test edin
        // "C:\Users\ibox4\Desktop\text.txt"
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        /*
        Bilgisayarımızdaki bir dosyanın varlıgını test etmek icin once o dosyaya ulasmamız gerekır
        Java'da dosyaya erisim icin dosya yoluna(path) ihtiyac vardır.
        Her bilgisayarin kullanıcı adi farklı olacagından masaustu dosya yolu da birbirinden farklı olacaktır
        Testlerımızın tum bılgısayarlarda calısması icin dosya yolunu DINAMIK yapmak zorundayız.

        Bunun icin
            her bilgisayarın birbirinden farklı olan yolunu bulmak icin
            String farkliKisim=System.getproperty("user.home)

            herkesin bilgisayarında ortak olan kisim ise
            String ortakKisim= "\Desktop\text.txt"

            String dosyaYolu=fakliKisim+ortakKisim;
         */

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }
}
