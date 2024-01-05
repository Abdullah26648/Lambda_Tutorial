package Tasks;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Task_01 {
    /*    2) "Q01" olarak adlandırılan bir class oluşturun
            3) 5 String öğesi içeren bir String listoluşturun.
            4) 3 tanesi "A" harfi ile başlayacak
            5) Elemanlar "A" harfi ile başlıyorsa ve elemanların uzunlukları
            5'ten küçükse, konsolda list olarak buyuk harflerle yazdırın.
       */
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        stringList.add("Apple");
        stringList.add("Orange");
        stringList.add("Ape");
        stringList.add("Banana");
        stringList.add("Ant");

        System.out.println(printStarswithAshorterthan5(stringList));

    }

    private static List<String> printStarswithAshorterthan5(List<String> stringList) {
        return stringList.stream()
                .filter(t -> t.startsWith("A") && t.length() < 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}