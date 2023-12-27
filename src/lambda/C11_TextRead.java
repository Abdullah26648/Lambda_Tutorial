package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class C11_TextRead {
    /*
    dosya eklemek icin 2 yol kullanılır
    1) Files.lines(Path.of("path")  buradan stream e eklemek icin
    Stream <String> satir=Files.lines(Path.of(".........."));
    bu bize tekrardan stream tanimlamadan kullanmayi saglar
    2) //Files.lines(Paths.get("..........")).  kullanilir
    ==========================================================
    intellj dosya eklemek icin src => new=>file=>text diyoruz ve istedigimiz metni buraya kopyaliyoruz
    bu dosyanin path almak icin dosyanin uzerine gelip sag tikliyoruz(burada dosya HalUk)
    sonrasinda copy path seciyoruz bundan sonra iki secenek var
    1) absolute path seciyoruz yada
    2) path from content root seciyoruz
    her ikisinde de path kopyalamis oluyoruz
    cevirirken EXCEPTION OLUSMASIN DIYE => throws IOException <= EKLEMELIYIZ
    buda lines altinda kirmizi uyari veriyor uzerine tiklayinca kendiliginden oluyor.
    */
    public static void main(String[] args) throws IOException {
        //TASK 01 --> haluk dosyasini Console'a print eden code create ediniz.
        System.out.println("****Task01*****");
        Path erisilecekdosya = Path.of("src/lambda/HalUk");
        Stream<String> dosyaAkısı = Files.lines(erisilecekdosya);
        //Stream<String> dosyaAkısı = Files.lines(Path.of("src/lambda/HalUk"));
        //dosyaAkısı.forEach(SeedMethods::stringPrint);
        dosyaAkısı.forEach(System.out::println);

        //TASK 02 --> haluk.txt dosyasini Console'a buyuk harflerle print eden code create ediniz.
        System.out.println("\n****Task02*****");

        Files.lines(erisilecekdosya).map(String::toUpperCase).forEach(System.out::println);

        //TASK 03 --> haluk dosyasindaki sadece ilk satiri kucuk harflerle print eden code create ediniz.
        System.out.println("\n****Task 03*****");

        Files.lines(erisilecekdosya).findFirst().map(String::toLowerCase).ifPresent(System.out::println);

        System.out.println("\n****Task 04*****");
        //TASK 04 --> haluk dosyasinda "basari" kelimesinin kac satirda gectigini print eden code create ediniz.

        System.out.println(Files.lines(erisilecekdosya).filter(t -> t.contains("basari")).count());

    }
}
