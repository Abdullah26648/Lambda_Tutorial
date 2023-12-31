package Tasks;

import java.util.List;
import java.util.stream.Collectors;

public class Task_04 {
    //        3) "Ali", "John", "Ali", "Alexander", "Taylor", "Ali", "Jackson" öğelerini içeren bir list oluşturun
    //        4) "J" ile baslayan öğeleri almayın
    //        5) Farklı öğeleri seçin
    //        6) Karakter sayısına göre doğal sıraya koyun
    //        7) Tüm öğeleri büyük harfe dönüştürün
    //        8) Konsoldaki öğeleri yazdırın
    //        9)Fonksiyonel Programlama'yı kullanın
    //        10)Bu tek bir soru
    //        */
    public static void main(String[] args) {
        List<String> nameList = List.of("Ali", "John", "Ali", "Alexander", "Taylor", "Ali", "Jackson");

        System.out.println(magicalformula(nameList));
    }
    private static List<String> magicalformula(List<String> nameList){
        return nameList.stream()
                .filter(name -> !name.startsWith("J"))
                .distinct()
                .sorted()
                .map(String::toUpperCase)
                .collect(Collectors.toList());
    }
}
