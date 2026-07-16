import java.util.Scanner;

public class stringreverse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Reverse by word
        String[] words = input.split("\\s+");
        StringBuilder reverseByWord = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i--) {
            reverseByWord.append(words[i]);
            if (i > 0) {
                reverseByWord.append(" ");
            }
        }

        // Reverse by letter
        StringBuilder reverseByLetter = new StringBuilder(input);
        reverseByLetter.reverse();

        System.out.println("Reverse by word: " + reverseByWord);
        System.out.println("Reverse by letter: " + reverseByLetter);

        sc.close();
    }
}
