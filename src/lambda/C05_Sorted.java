package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class C05_Sorted {
//    Sorted:
//    Bazı durumlarda elimizde ki veri setini belirli bir parametreye göre sıralamak isteyebiliriz.
//            2 türü bulunmaktadır. Birinci hali parametre almaz küçükten büyüğe şekilde sıralar.
//    İkinci formatı ise Comparator arayüzünden türediği için
//    bizim belirlemiş olduğumuz parametreye göre sıralama işlemi yapar.
public static void main(String[] args) {
    List<Integer> sayiList = new ArrayList<>(Arrays.asList(7, 12, 15, 2, 5, 6, 3, 89, 43, 34, 22, 58, 50, 71, 35));
    System.out.println("****Task01*****");
    printciftkaresi(sayiList);
    System.out.println("\n****Task02*****");
    printtekkaresi(sayiList);

    }
    // Task01-> list çift elemanlarının karelerini k->b sıra ile print eden code create ediniz
    public static void printciftkaresi(List<Integer> sayiList) {
        sayiList.stream().filter(SeedMethods::ciftMi).map(SeedMethods::kareAl).sorted().forEach(SeedMethods::intPrint);
    }
    /*
    sorted() -> akışdaki elemanları naturel order (doğal sıra) halinde akış return eder
    sorted() tekrarlı kullanılırsa son return aktif olur...
    */
    // Task02-> list tek elemanlarının karelerini b->k sıra ile print eden code create ediniz
    public static void printtekkaresi(List<Integer> sayiList) {
        sayiList.stream().filter(SeedMethods::tekMi).map(SeedMethods::kareAl).sorted(Comparator.reverseOrder()).forEach(SeedMethods::intPrint);
    }
}