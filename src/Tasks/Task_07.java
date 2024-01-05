package Tasks;

import java.util.stream.Collectors;

public class Task_07 {
    /*
    Write a return method  that can find the unique characters from the String
    Ex:unique("AAAABBBCCCDEF") => "DEF"
     */
    public static void main(String[] args) {
        String str = "AAAABBBCCCDEF";
        System.out.println(findUniqueCharacters(str));
    }

    private static String findUniqueCharacters(String str) {
        return str.chars()
                .distinct()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
