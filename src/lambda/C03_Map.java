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
        List<Integer> sayiList = new ArrayList<>(Arrays.asList(7, 12, 15, 2, 5, 6, 3, 89, 43, 34, 22, 58, 50, 71, 35));
        System.out.println("****Task01*****");
        printCiftKare(sayiList);//144 4 36 1156 484 3364 2500
        System.out.println("\n****Task02*****");
        printTekKupArtiBir(sayiList);//344 3376 126 28 704970 79508 357912 42876
        System.out.println("\n****Task03*****");
        printCiftKok(sayiList);//3 1 2 5 4 7 7
        System.out.println("\n****Task04*****");

    }

    // Task01-> listin çift elemanlarının karelerini aynı satıra aralarına bosluk bırakarak print eden code create ediniz.
    private static void printCiftKare(List<Integer> sayiList) {
        sayiList
                .stream()//list elemanları akısa alındı
                .filter(SeedMethods::ciftMi)//Akisa alinan cift elemanlar filtrelendi
                //.map((t) -> (int) Math.pow(t, 2))
                //.map((t) -> t*t)
                .map(SeedMethods::kareAl)//cift sarta fitrelenen list elemanları karesine update edildi
                .forEach(SeedMethods::intPrint);//yazdirildi
    }

    // Task02 : Functional Programming ile listin tek elemanlarinin  kuplerinin bir fazlasini ayni satirda aralarina bosluk birakarak print eden code create ediniz.
    private static void printTekKupArtiBir(List<Integer> sayiList) {
        sayiList
                .stream()
                .filter(SeedMethods::tekMi)
                //.map((t) -> (int) Math.pow(t, 3)+1)
                .map((t) -> t * t * t + 1)
                .forEach(SeedMethods::intPrint);
    }

    // Task03-> Functional Programming ile listin cift elemanlarinin karekoklerini ayni satirda aralarina bosluk birakarak print eden code create ediniz.
    private static void printCiftKok(List<Integer> sayiList) {
        sayiList
                .stream()
                .filter(SeedMethods::ciftMi)
                .map((t) -> (int) Math.sqrt(t))
                .forEach(SeedMethods::intPrint);
    }
}
