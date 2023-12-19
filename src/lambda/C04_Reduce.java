package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class C04_Reduce {
    /*
        reduce()-->azaltmak ... bir cok datayi tek bir dataya(max min carp top vs islemlerde) cevirmek icin kullanilir.
        kullanımı yaygındır pratiktir.
        Bir Stream içerisindeki verilerin teker teker işlenmesidir. Teker teker işleme sürecinde, bir önceki adımda elde edilen sonuç
        bir sonraki adıma girdi olarak sunulmaktadır. Bu sayede yığılımlı bir hesaplama süreci elde edilmiş olmaktadır.
        reduce metodu ilk parametrede identity değeri, ikinci parametrede ise BinaryOperator türünden bir obj kullanılır.
        reduce işleminde bir önceki hesaplanmış değer ile sıradaki değer bir işleme tabi tutulmaktadır.
        İşleme başlarken bir önceki değer olmadığı için bu değer identity parametresinde tanımlanmaktadır.
        */
    public static void main(String[] args) {
        List<Integer> sayiList = new ArrayList<>(Arrays.asList(7, 12, 15, 2, 5, 6, 3, 89, 43, 34, 22, 58, 50, 71, 35));
        System.out.println("****Task01*****");
        printCiftKareMax(sayiList);//Optional[3364]
        System.out.println("\n****Task02*****");
        System.out.println("Toplam : " + printElTopla(sayiList));
        printElTopla1(sayiList);
        System.out.println("\n****Task03*****");
        printCiftCarp(sayiList);
        System.out.println("\n****Task04*****");
        printMinEl(sayiList);
        System.out.println("\n****Task05*****");
        System.out.println(printTek58BykMin(sayiList));
    }

    //Task01-> list çift elemanlarının karelerinin en buyugunu print code create ediniz...
    private static void printCiftKareMax(List<Integer> sayiList) {
//        Optional<Integer> maxSayi =sayiList
//                .stream()
//                .filter(SeedMethods::ciftMi)
//                .map(SeedMethods::kareAl)
//                .reduce(Math::max);
//        System.out.println(maxSayi);
        System.out.println(sayiList
                .stream()
                .filter(SeedMethods::ciftMi)
                .map(SeedMethods::kareAl)
                .reduce(Math::max));
    }

    //Task02-> list elemanlarının toplamını  print code create ediniz...
    public static Optional<Integer> printElTopla(List<Integer> sayiList) {
        return sayiList
                .stream()
                //.reduce(Math::addExact);app. yavaslatir
                .reduce(Integer::sum);//specific data oldugu icin daha hizlidir
    }

    public static void printElTopla1(List<Integer> sayiList) {
        System.out.println(sayiList
                .stream()
                //.reduce(Math::addExact);app. yavaslatir
                //.reduce(Integer::sum);//specific data oldugu icin daha hizlidir
                .reduce(0, (a, b) -> a + b));//specific data old için app. hızlı çalışır.

        /*
        a: ilk değerini her zaman  atanan identity değerden alır.
        b: değerini her zaman degerlerini Stream()'den alır
        a: ilk değerden sonraki değerini action(işlem body)'den alır
          */
    }

    //Task03-> list'in çift elemanlarının çarpımını print code create ediniz...
    public static void printCiftCarp(List<Integer> sayiList) {
        System.out.println(sayiList
                .stream()
                .filter(SeedMethods::ciftMi)
                //.reduce(Math::multiplyExact)//app. yavaslatir
                .reduce(1, (t, u) -> t * u)//specific data old için app. hızlı çalışır.
        );
    }

    //Task04-> list elemanlarının en küçüğünü  print code 4 farklı code create ediniz...
    public static void printMinEl(List<Integer> sayiList) {
        //1.yol
        System.out.println("1.yol Math ref ile : " + sayiList.stream().reduce(Math::min));
        //2.yol
        System.out.println("2. yol Integer ref ile : " + sayiList.stream().reduce(Integer::min));
        //3.yol
        //System.out.println("3.yol metod ref ile : " + sayiList.stream().reduce(SeedMethods::minBul));
        //4.yol
        System.out.println("4.yol identity ref ile : " + sayiList.stream().reduce(sayiList.get(0), (t, u) -> t < u ? t : u));
    }

    // Task05-> List elemanlarının 58'den buyuk en kucuk tek elemanını print eden code create ediniz...
    public static Optional<Integer> printTek58BykMin(List<Integer> sayiList) {
        return sayiList
                .stream()
                .filter((t) -> t % 2 == 1 && t > 58)
                //.reduce(Math::min);
                .reduce(Integer::min);

        // System.out.println(sayiList.stream().filter(t -> t > 58 && SeedMethods::ciftMi).reduce(Integer::min));
        // Ahan da trick köşesinde böğün :) CTE-> exp ve meth. ref aynı pararmetrede tanımlanamaz
    }
}