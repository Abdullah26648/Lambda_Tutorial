package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C03_Map {
    /*
    Map :Stream içerisinde erişilen her bir eleman üzerinde işlem yapmamıza
    ve başka elemanlara dönüştürmemize imkan sağlayar
     */
    public static void main(String[] args) {
        List<Integer> sayiList = new ArrayList<>(Arrays.asList(7,12,15,2,5,6,3,89,43,34,22,58,50,71,35));
        System.out.println("***Task01***");
        printCiftKareFunctional(sayiList);
        System.out.println("\n***Task02***");
        printCiftKareFunctional(sayiList);
        System.out.println("\n***Task03***");
        printTekKupartı1Functional(sayiList);
        System.out.println("\n***Task04***");
        printcifkokFunctional(sayiList);
    }
    // Task01-> listin çift elemanlarının karelerini aynı satıra aralarına bosluk bırakarak print eden code create ediniz.
    private static void printCiftKareFunctional(List<Integer> sayiList) {
        sayiList.stream().filter(SeedMethods::ciftmi).map((t)->(int)Math.pow(t,2)).forEach(SeedMethods::intPrint);
        sayiList.stream().filter(SeedMethods::ciftmi).map(SeedMethods::karesi).forEach(SeedMethods::intPrint);

    }
    // Task02 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print eden code create ediniz.
    private static void printTekKupartı1Functional(List<Integer> sayiList) {
        sayiList.stream().filter(SeedMethods::tekmi).map(SeedMethods::kupu).map(SeedMethods::birfazlası).forEach(SeedMethods::intPrint);
    }
    // Task03-> Functional Programming ile listin cift elemanlarinin   karekoklerini ayni satirda aralarina bosluk birakarak print eden code create ediniz.
    private static void printcifkokFunctional(List<Integer> sayiList) {
        sayiList.stream().filter(SeedMethods::ciftmi).map((t)->(int)Math.sqrt(t)).forEach(SeedMethods::intPrint);
    }
}
