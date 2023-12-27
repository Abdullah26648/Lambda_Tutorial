package lambda;

import java.util.stream.IntStream;

public class C13_Stream_Iterator {
    //range(startInclusive,endExclusive);-> 1'lik artımlı bir adımla
    // startInclusive'den (dahil) endExclusive'e (hariç) kadar sıralı bir IntStream return eder.

    //rangeClosed(startInclusive,endInclusive);-> 1'lik artımlı bir adımla
    // startInclusive'den (dahil) endInclusive'e (dahil) kadar  sıralı bir IntStream return eder.
    public static void main(String[] args) {
        System.out.println("TASK01--> amele topla : " + ameleTopla(10)); // 55
        System.out.println("   ***   ");
        System.out.println("TASK01--> cincix topla : " + cincixTopla(10)); // 55
        System.out.println("   ***   ");
        System.out.println("TASK02--> ciftTopla : " + ciftTopla(10)); // 30
        System.out.println("   ***   ");
        System.out.println("TASK03--> " + ilkxciftTopla(10)); // 6
        System.out.println("   ***   ");
        System.out.print("TASK04--> "); // 2 4 6 8 10 12 14 16 18 20
        ilkxciftPrint(10);
        System.out.println("\n   ***   ");
        System.out.println("TASK05--> " +ilkXPozitifTekSayiTopla(10));// 100
        System.out.println("   ***   ");
        System.out.print("TASK06--> ");// 3 9 27 81 243 729 2187 6561 19683 59049
        ilkxkuvvetPrint(10, 3);
        System.out.println("\n   ***   ");
        System.out.println("TASK07--> " +factoriyel(10));// 3628800


    }

    //TASK 01 --> Structured Programming ve Functional Programming ile 1'den x'e kadar tamsayilari toplayan bir code create ediniz.
    private static int ameleTopla(int x) {
        int toplam = 0;
        for (int j = 1; j < x; j++) {
            toplam += j;
        }
        return toplam;
    }

    private static int cincixTopla(int x) {
        return IntStream
                //.range(1,x)
                .rangeClosed(1, x)
                .sum();
    }

    //TASK 02 --> 1'den x'e kadar cift tamsayilari toplayan bir code create ediniz
    public static int ciftTopla(int x) {
        return IntStream
                .rangeClosed(1, x)
                .filter(SeedMethods::ciftMi)
                .sum();
    }

    //TASK 03 --> Ilk x pozitif cift tam sayiyi toplayan code  create ediniz.
    public static int ilkxciftTopla(int x) {
        return IntStream
                .iterate(2, t -> t + 2)
                .limit(x)
                .sum();
    }
    public static void ilkxciftPrint(int x) {
        IntStream
                .iterate(2, t -> t + 2)
                .limit(x)
                .forEach(SeedMethods::intPrint);
    }

    //TASK 05 --> Ilk X pozitif tek tamsayiyi toplayan programi  create ediniz.
    public static int ilkXPozitifTekSayiTopla(int x) {
        return IntStream.iterate(1, i -> i + 2)
                .limit(x)
                .sum();
    }

    //TASK 06 --> Istenilen bir sayinin ilk x kuvvetini print eden code  create ediniz.
    public static void ilkxkuvvetPrint(int x, int y) {
        IntStream
                .iterate(y, t -> t * y)
                .limit(x)
                .forEach(SeedMethods::intPrint);
    }

    //TASK 07 --> Istenilen bir sayinin faktoriyelini hesaplayan code  create ediniz.
    public static long factoriyel(int x) {
        return IntStream.rangeClosed(1, x)
                .mapToLong(Long::valueOf)
                .reduce(1, (t, u) -> t * u);
    }
}
