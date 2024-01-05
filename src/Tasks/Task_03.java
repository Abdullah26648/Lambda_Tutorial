package Tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Task_03 {
    //String isimlerden olusan bir list olusturun
    //Konsoldaki farklı öğeleri uzunluklarıyla birlikte yazdırın.
    //Konsoldaki farklı öğeleri yazdırın, uzunluklarına göre sıralayın.
    //Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
    //Konsoldaki farklı öğeleri ters sırada yazdırın.
    //Uzunluğu 7'den küçük olan farklı öğeleri ters sırada konsolda büyük harflerle yazdırın.
    //Bunlarin hepsi ayri ayri sorular arkadaslar
    public static void main(String[] args) {
        List<String> nameList = new ArrayList<>();
        nameList.add("Alice");
        nameList.add("Bob");
        nameList.add("Charlie");
        nameList.add("David");
        nameList.add("Eve");

        // Konsoldaki farklı öğeleri uzunluklarıyla birlikte yazdırın.
        System.out.println("Uzunluklarıyla birlikte: ");
        nameList.forEach(name -> System.out.println(name + " - " + name.length()));
        System.out.print("   *** *** *** *** ***   ");
        // Konsoldaki farklı öğeleri yazdırın, uzunluklarına göre sıralayın.
        System.out.println("\nUzunluklarına göre sıralı: ");
        nameList.stream()
                .sorted(Comparator.comparingInt(String::length))
                .forEach(Task_03::printstr);
        System.out.print("\n   *** *** *** *** ***   ");
        // Konsoldaki farklı öğeleri yazdırın, son karakterlerine göre sıralayın.
        System.out.println("\nSon karakterlere göre sıralı: ");
        nameList.stream()
                .sorted(Comparator.comparingInt(s -> s.charAt(s.length() - 1)))
                .forEach(Task_03::printstr);
        System.out.print("\n   *** *** *** *** ***   ");
        // Konsoldaki farklı öğeleri ters sırada yazdırın.
        System.out.println("\nTers sıralı: ");
        nameList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(Task_03::printstr);
        System.out.print("\n   *** *** *** *** ***   ");
        // Uzunluğu 7'den küçük olan farklı öğeleri ters sırada konsolda büyük harflerle yazdırın.
        System.out.println("\nUzunluğu 7'den küçük ve ters sıralı büyük harflerle: ");
        nameList.stream()
                .filter(name -> name.length() < 7)
                .sorted(Comparator.reverseOrder())
                .map(String::toUpperCase)
                .forEach(Task_03::printstr);
    }
    public static void printstr(String a){
        System.out.print(a+" ");
    }
}
