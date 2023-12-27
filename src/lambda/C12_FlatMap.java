package lambda;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Stream;

public class C12_FlatMap {
    /*
   Stream.flatMap, adıyla tahmin edilebileceği gibi, bir map ve flat işleminin birleşimidir. Bu, ilk önce elemanlarınıza bir
   fonksiyon uyguladığınız ve daha sonra düzleştirdiğiniz anlamına gelir.
   Stream.map yalnızca akışı düzleştirmeden bir işlevi uygular.

   Bir akışın düzleştirme'in neyi içerdiğini anlamak için, "iki seviye" olan [ [1,2,3],[4,5,6],[7,8,9] ] gibi bir yapı düşünün.
   Bunun düzleştirilmesi, "bir seviye" yapısında dönüştürülmesi anlamına gelir: [ 1,2,3,4,5,6,7,8,9 ].
   flatMap yöntemi, bir akışın her bir değerini başka bir akışla değiştirmenizi sağlar
   ve ardından oluşturulan tüm akışları tek bir akışa birleştirir.
 */
    public static void main(String[] args) throws IOException {
        Path erisilecekDosya=Path.of("src/lambda/HalUk");
        Stream<String> dosyaAkisi= Files.lines(erisilecekDosya);

        //TASK 05 -> HalUk dosyasindaki farkli kelimeleri print ediniz..
        System.out.println("****Task05****");
        Files.lines(erisilecekDosya)
                .map(t->t.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(SeedMethods::stringPrint);

        //TASK 06 -> HalUk dosyasindaki tum kelimeleri natural order  print ediniz..
        System.out.println("\n****Task06****");
        Files.lines(erisilecekDosya)
                .map(t->t.split(" "))
                .flatMap(Arrays::stream)
                .sorted()
                .forEach(System.out::println);

        //TASK 07 -> HalUk dosyasinda "basari" kelimesinin kac kere gectigini buyuk harf kucuk harf bagımsız print ediniz.
        System.out.println("\n****Task07****");
        System.out.println(Files.lines(erisilecekDosya)
                .map(t -> t.toLowerCase().split(" "))
                .flatMap(Arrays::stream)
                .filter(t -> t.equals("basari"))
                .count());

        //TASK 08 -> HalUk dosyasinda "a" harfi gecen kelimelerin sayisini print eden  programi create ediniz.
        System.out.println("\n****Task08****");
        System.out.println(Files.lines(erisilecekDosya)
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .filter(t -> t.contains("a"))
                .count());

        //TASK 09 -> HalUk dosyasinda icinde "a" harfi gecen kelimeleri print ediniz.
        System.out.println("\n****Task09****");
        Files.lines(erisilecekDosya)
                .map(t -> t.split(" "))
                .flatMap(Arrays::stream)
                .filter(t -> t.contains("a"))
                .forEach(SeedMethods::stringPrint);

        //TASK 10 -> HalUk dosyasinda kac farklı harf kullanildigini print ediniz.
        System.out.println("\n****Task 10****");
        System.out.println(Files.lines(erisilecekDosya)
                .map(t -> t.toLowerCase().replaceAll("\\W","").split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .count());

        //TASK 11 -> HalUk dosyasinda kac farkli kelime kullanildigini print ediniz.
        System.out.println("\n****Task 11****");
        System.out.println(Files.lines(erisilecekDosya)
                .map(t -> t.replaceAll("[^a-zA-Z ]", "").split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .count());

        //TASK 12 -> HalUk dosyasinda  farkli kelimeleri print ediniz.
        System.out.println("\n****Task 12****");
        Files.lines(erisilecekDosya)
                .map(t -> t.replaceAll("[^a-zA-Z ]", "").split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .forEach(t-> System.out.print(t+" "));
    }
}
