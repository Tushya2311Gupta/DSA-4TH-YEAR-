import java.util.*;
import java.io.*;
public class StringPalindrome {
    public static boolean isPalindromePointer(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        int left = 0, right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindromeReversal(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
    public static boolean isPalindromeStack(String s) {
        String str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        java.util.Stack<Character> stack = new java.util.Stack<>();
        
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        
        for (char c : str.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
    public static boolean isPalindromeSimple(String s) {
        int n = s.length();
        for (int i = 0; i < n / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test cases
        // String[] testCases = {
        //     "racecar",
        //     "hello",
        //     "A man, a plan, a canal: Panama",
        //     "Was it a car or a cat I saw?",
        //     "madam",
        //     "12321",
        //     "level"
        // };
        Scanner sc=new Scanner(System.in);
        String a=sc.nextLine();
        String[] testCases = {a};

        System.out.println("String Palindrome Checker\n");
        System.out.println("=".repeat(60));

        for (String test : testCases) {
            boolean result = isPalindromePointer(test);
            System.out.println("String: \"" + test + "\"");
            System.out.println("Is Palindrome: " + result);
            System.out.println("-".repeat(60));
        }

        // Performance comparison
        System.out.println("\nPerformance Test with 100,000 iterations:");
        String largeString = "a".repeat(5000) + "b" + "a".repeat(5000);
        
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            isPalindromePointer(largeString);
        }
        System.out.println("Two Pointer Approach: " + (System.currentTimeMillis() - start) + "ms");

        start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            isPalindromeReversal(largeString);
        }
        System.out.println("Reversal Approach: " + (System.currentTimeMillis() - start) + "ms");
    }
}
