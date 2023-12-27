package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C07_Match {
    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir eleman sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.
    public static void main(String[] args) {
        List<String> yemahhh = new ArrayList<String>(Arrays.asList("küşleme", "küşleme", "küşleme", "soğanlı", "soğanlı", "soğanlı", "trileçe", "bicibici", "büryan", "melemen", "cacix", "kokereç", "yağlama", "güveç", "arabAşı", "tantuni"));
        System.out.println("****Task01*****");
        System.out.println(print7orless(yemahhh));
        System.out.println("\n****Task02*****");
        System.out.println(printWilebaslamama(yemahhh));
        System.out.println("\n****Task03*****");
        System.out.println(printxilebitme(yemahhh));

    }
    // Task01->  List elemanlarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol eden code create ediniz.
    private static String print7orless(List<String> yemahhh) {
        //yemahhh.stream().map(String::length).filter(SeedMethods::Sevenandless).forEach(SeedMethods::intPrint);
        return yemahhh.stream().allMatch((t)-> t.length()<=7)?"true":"false";
    }
    // Task02-> List elemanlarinin hiçbirinin "W" ile baslamamasını kontrol eden code create ediniz...
    private static String printWilebaslamama(List<String> yemahhh) {
        return yemahhh
                .stream()
                .noneMatch((t) -> t.substring(0, 1).equalsIgnoreCase("w")) ?
                "Menude w ile baslayan bir yemek yok" :
                "Menude W ile baslayan en az bir yemek var";
        //return yemahhh.stream().noneMatch((t)->t.substring(0,1).equalsIgnoreCase("w"))? "True":"False";
    }
    // Task03-> List elemanlarinin "x" ile biten en az bir elemanın varlığını kontrol ediniz eden code create ediniz...
    private static String printxilebitme(List<String> yemahhh) {
//            return yemahhh.stream().anyMatch(t -> t.endsWith("x")) ?
//                    "Menude en az bir tane X ile biten yemek var" :
//                    "Menude en az bir tane X ile biten yemek yok";
        return yemahhh.stream().anyMatch(t -> t.endsWith("x"))? "True":"False";

    }
}
