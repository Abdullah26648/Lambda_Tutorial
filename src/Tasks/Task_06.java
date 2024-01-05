package Tasks;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Task_06 {

    // S1 : tum elemanlari list yapalim

    // S2: E ile baslayan elemanlari double (elmaelma) olarak yazdiralim

    // S3: E ile baslayan elemanlari liste olarak yazdiralim

    //S4 : k ile bitenlerin sonuna '*' ekleyelim

    public static void main(String[] args) {
        String arr[][] = {
                {"Elma", "Muz"},
                {"Portakal", "Cilek", "Limon"},
                {"Havuc","Erik"}
        };
        System.out.println("\n   *** *** *** 1 *** *** ***   ");
        // S1: Tüm elemanları list yapalım
        flattenArray(arr);
        System.out.println("\n   *** *** *** 2 *** *** ***   ");
        // S2: E ile başlayan elemanları double (elmaelma) olarak yazdıralım
        printDoubleElementsStartingWithE(arr);
        System.out.println("\n   *** *** *** 3 *** *** ***   ");
        // S3: E ile başlayan elemanları liste olarak yazdıralım
        filterElementsStartingWithE(arr);
        System.out.println("\n   *** *** *** 4 *** *** ***   ");
        // S4: K ile bitenlerin sonuna '*' ekleyelim
        addAsteriskToEndOfElementsEndingWithK(arr);
    }

    private static void flattenArray(String[][] arr) {
        Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .collect(Collectors.toList())
                .forEach(element -> System.out.print(element + " "));
    }

    private static void printDoubleElementsStartingWithE(String[][] arr) {
        Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .filter(element -> element.startsWith("E"))
                .forEach(element -> System.out.print(element + element + " "));
    }

    private static void filterElementsStartingWithE(String[][] arr) {
        Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .map(String::toUpperCase)
                .filter(element -> element.startsWith("E"))
                .forEach(element -> System.out.print(element + " "));
    }

    private static void addAsteriskToEndOfElementsEndingWithK(String[][] arr) {
        Arrays.stream(arr)
                .flatMap(Arrays::stream)
                .map(String::toUpperCase)
                .filter(element -> element.endsWith("K"))
                .forEach(element -> System.out.print(element + "* "));
    }
}
