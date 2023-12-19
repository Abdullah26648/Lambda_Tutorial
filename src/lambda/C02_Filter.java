package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C02_Filter {
        /*
        Filter:
        Dizimiz veya Collection’ımız üzerinde bizim belirteceğimiz koşullar doğrultusunda
        filtreleme işlemi yapmamıza yarayan bir yapıdır.
        Bu işlem sonrası belirttiğimiz koşula uygun olmayan elemanlar bir sonraki aşamada kullanılamazlar.
        Artık elimizde filtrelenmiş/süzülmüş/elenmiş bir veri vardır
        */
    public static void main(String[] args) {
        List<Integer> sayiList = new ArrayList<>(Arrays.asList(7, 12, 15, 2, 5, 6, 3, 89, 43, 34, 22, 58, 50, 71, 35));
        System.out.println("****Task01*****");
        printCiftStructured(sayiList);//12 2 6 34 22 58 50
        System.out.println("\n****Task02*****");
        printCiftFunctional(sayiList);//12 2 6 34 22 58 50
        System.out.println("\n****Task03*****");
        print35KckCiftFunctional(sayiList);
        System.out.println();
        print35KckCiftFunctional1(sayiList);
        System.out.println("\n****Task04*****");
        print34BykTekFunctional1(sayiList);//7 15 5 3 89 43 58 50 71 35
    }

    //Task01->"Structured Programming"--> AMELE Programming kullanarak  listin çift elemanlarını aynı satırda aralarında bosluk ile print ediniz
    private static void printCiftStructured(List<Integer> sayiList) {
        for (Integer each : sayiList) {
            if (each % 2 == 0) {
                System.out.print(each + " ");
            }
        }
    }
    //task02-> "Functional Programming"--> CINCIX Programming kullanarak  listin çift elemanlarını aynı satırda aralarında bosluk ile print ediniz
    private static void printCiftFunctional(List<Integer> sayiList) {
        sayiList//aksiyona girecek akis kaynagi call edildi
                .stream()//call edilen coll. elemanlari akisa alindi
                //.filter((t)->t%2==0)
                .filter(SeedMethods::ciftMi)//akisdaki cift elemanlar filtrelendi
                .forEach(SeedMethods::intPrint);//akisdaki cifte gore filtrelenen elemanlar print edildi
    }
    //task03-> "Functional Programming"--> CINCIX Programming kullanarak  listin 35'den kucuk çift elemanlarını aynı satırda aralarında bosluk ile print ediniz
    private static void print35KckCiftFunctional(List<Integer> sayiList) {
        sayiList
                .stream()
                .filter(t -> t < 35 && t % 2 == 0)
//                .filter((t)->t<35)
//                .filter(SeedMethods::ciftMi)
                .forEach(SeedMethods::intPrint);
    }
    private static void print35KckCiftFunctional1(List<Integer> sayiList) {
        sayiList
                .stream()
//                .filter((t)->t<35)
//                .filter(SeedMethods::ciftMi)
                .filter(SeedMethods::cift35Kck)
                .forEach(SeedMethods::intPrint);
    }
    //task04-> "Functional Programming"--> CINCIX Programming kullanarak  listin 34'den buyuk yada  tek elemanlarını aynı satırda aralarında bosluk ile print ediniz
    private static void print34BykTekFunctional1(List<Integer> sayiList) {
        sayiList
                .stream()
                //.filter((t)->t>34||t%2==1)
                .filter(SeedMethods::tek34Byk)
                .forEach(SeedMethods::intPrint);
    }
}