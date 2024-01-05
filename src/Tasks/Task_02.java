package Tasks;

import java.util.ArrayList;
import java.util.List;

public class Task_02 {
    //        2) Bir class oluşturun, 'Q02' olarak adlandırın
//        3) 5 elemanlı bir tamsayı listesi oluşturun
//        4) Elemanlari doğal sıraya koyun
//        5)Konsoldaki son 3 elemanın karelerinin toplamını bulun.
//        6) Konsoldaki toplamı yazdırın
//        7) 'Fonksiyonel Programlama' kullanın
    public static void main(String[] args) {
        List<Integer> intList = new ArrayList<>(List.of(5, 2, 8, 3, 1));
        intList.sort(Integer::compareTo);
        System.out.println(sumOfSquares(intList));

    }
    private static int sumOfSquares(List<Integer> intList) {
        return intList.stream().skip(intList.size() - 3)
                .map(x -> x * x)
                .mapToInt(Integer::intValue)
                .sum();
    }
}
