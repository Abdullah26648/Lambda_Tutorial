package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class C08_Limit {
    //limit(a) akısdan cıkan elemanları a parametresine gore ilk a elamanı alır.
    /*
    Limit
    Elimizde var olan bir veri kaynağını, göstermek istediğimiz kadarını göstermemize yarayan,
    sınırlandıran bir metoddur. Parametre olarak vereceğimiz rakamla aslında
    Stream içerisinde dönen çok sayıda veri var
    ancak sen bize şu kadarını göster diyoruz.
     */
    public static void main(String[] args) {
        List<String> yemahhh = new ArrayList<String>(Arrays.asList("küşleme", "küşleme", "küşleme", "soğanlı", "soğanlı", "soğanlı", "trileçe", "bicibici", "büryan", "melemen", "cacix", "kokereç", "yağlama", "güveç", "arabAşı", "tantuni"));
        //List<String> yemahhh = new ArrayList<String>(Arrays.asList("küşleme", "küşleme", "küşleme", "soğanlı", "soğanlı", "soğanlı", "trileçe"));
        System.out.println("****Task01*****");
        printEnBykCharEleman(yemahhh);
    }

    // Task-> list elemanlarının karakter sayısı en buyuk olanı print code create ediniz...
    public static void printEnBykCharEleman(List<String> yemahhh) {
        System.out.println("***Versiyon01****");
        System.out.println(yemahhh
                .stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(1));

        /*
        limit(a)-> return typ bir Stream oldg için yani yeni bir eleman akışı oldg için birden çok eleman return edebilir.
        dolayısıyla limit() meth. çıktısı doğrudan sout parametre olamaz(print edilemez) .
        limit() meth cıktısı array veya List gibi bir collectiona atanmalı.
         */
        System.out.println("***Versiyon02****");
        Stream<String> enBykCharEl=yemahhh
                .stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(1);
        //System.out.println(enBykCharEl.collect(Collectors.toList()));
        System.out.println("***Versiyon03****");
        System.out.println(Arrays.toString(enBykCharEl.toArray()));
        System.out.println("***Versiyon04****");
        System.out.println(yemahhh
                .stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .findFirst());
        System.out.println("***Versiyon05****");
        yemahhh
                .stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(3)
                .forEach(SeedMethods::stringPrint);
    }
}
