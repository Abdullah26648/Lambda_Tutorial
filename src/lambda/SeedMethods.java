package lambda;

public class SeedMethods {
    public static void intPrint(int a) {
        System.out.print(a + " ");
    }

    public static boolean ciftMi(int x) {
        return x % 2 == 0;
    }

    public static boolean cift35Kck(int x) {
        return x < 35 && x % 2 == 0;
    }

    public static boolean tek34Byk(int x) {
        return x > 34 || x % 2 == 1;
    }

    public static int kareAl(int x) {
        return x * x;
    }

    public static boolean tekMi(int x) {
        return x % 2 == 1;
    }

    public static int minBul(int x, int y) {
        return x < y ? x : y;
    }

    public static void stringPrint(String a) {
        System.out.print(a + " ");
    }
}