package Tasks;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task_05 {
    public static void main(String[] args) throws IOException {

    // S1:TextFile dosyasini yazdiralim
    

    //S2: textFile dosyasinin tum harflari buyuk harf ile yazdiralim
    

    // S3: textFile dosyasinin son satirini buyuk harfle yazdiralim
    

    //S4: textFile dosyasinin 2.ve 3. satirlari yazdiralim
    

    //S5: textFile dosyasinda kac tane "icin" kelimesi vardir


    //S6: textFile dosyasinin tum kelimeleri natural order  yazdiriniz.
    
	
    // S7: textFile dosyasinda kac tane "n" vardir


        String filePath = "src/lambda/HalUk";

        System.out.println("\n   *** *** *** 1 *** *** ***   ");
        printFileContent(filePath);

        System.out.println("\n   *** *** *** 2 *** *** ***   ");;
        printFileContentInUpperCase(filePath);

        System.out.println("\n   *** *** *** 3 *** *** ***   ");
        printLastLineInUpperCase(filePath);

        System.out.println("\n   *** *** *** 4 *** *** ***   ");
        printSpecificLines(filePath, 2, 3);

        System.out.println("\n   *** *** *** 5 *** *** ***   ");
        countOccurrencesiçin(filePath, "için");

        System.out.println("\n   *** *** *** 6 *** *** ***   ");
        printWordsInNaturalOrder(filePath);

        System.out.println("\n   *** *** *** 7 *** *** ***   ");
        countOccurrencesn(filePath, "n");
    }
    private static void printFileContent(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        lines.forEach(System.out::println);
    }

    private static void printFileContentInUpperCase(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        lines.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

    private static void printLastLineInUpperCase(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        String lastLine = lines.get(lines.size() - 1).toUpperCase();
        System.out.println(lastLine);
    }

    private static void printSpecificLines(String filePath, int line1, int line2) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        System.out.println(lines.get(line1 - 1));
        System.out.println(lines.get(line2 - 1));
    }

    private static void countOccurrencesiçin(String filePath, String targetWord) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        long count = lines.stream()
                .flatMap(line -> List.of(line.split("\\s+")).stream())
                .filter(word -> word.equals(targetWord))
                .count();
        System.out.println("Occurrences of \"" + targetWord + "\": " + count);
    }

    private static void printWordsInNaturalOrder(String filePath) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        lines.stream()
                .flatMap(line -> List.of(line.split("\\s+")).stream())
                .sorted()
                .forEach(System.out::println);
    }

    private static void countOccurrencesn(String filePath, String targetChar) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath));
        long count = lines.stream()
                .flatMap(line -> line.chars().mapToObj(c -> (char) c))
                .filter(ch -> ch.toString().equals(targetChar))
                .count();
        System.out.println("Occurrences of '" + targetChar + "': " + count);
    }

}
