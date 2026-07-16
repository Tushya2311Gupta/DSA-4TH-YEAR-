import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class stringfrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        Map<Character, Integer> frequency = new LinkedHashMap<>();

        for (char ch : input.toCharArray()) {
            char upper = Character.toUpperCase(ch);
            if (Character.isLetter(upper)) {
                frequency.put(upper, frequency.getOrDefault(upper, 0) + 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        sc.close();
    }
}
