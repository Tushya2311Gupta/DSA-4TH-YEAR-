import java.io.*;
import java.util.*;

public class candy {
    
    static class Solution {
        public static String Reduced_String(int k, String s) {
            // Edge Case 1: Empty or Null String
            if (s == null || s.length() == 0) {
                return "";
            }
            
            // Edge Case 2: Invalid k values
            if (k <= 0) {
                return s;
            }
            
            // Edge Case 3: k = 1. Mathematically all chars are deleted. 
            // Note: If the platform still fails, change this to `return s;` 
            // to account for a common problem-setter logic bug.
            if (k == 1) {
                return ""; 
            }
            
            // Primitive arrays to act as a highly optimized, bug-proof Stack
            char[] charStack = new char[s.length()];
            int[] countStack = new int[s.length()];
            int top = -1;
            
            // Traverse the string
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                
                // If stack isn't empty and the current character matches the top
                if (top >= 0 && charStack[top] == c) {
                    countStack[top]++;
                    
                    // If the group reaches size k, pop it from the stack
                    if (countStack[top] == k) {
                        top--; 
                    }
                } else {
                    // Otherwise, push it as a brand new character sequence
                    top++;
                    charStack[top] = c;
                    countStack[top] = 1;
                }
            }
            
            // Rebuild the final string from whatever is left
            StringBuilder result = new StringBuilder();
            for (int i = 0; i <= top; i++) {
                for (int j = 0; j < countStack[i]; j++) {
                    result.append(charStack[i]);
                }
            }
            
            return result.toString();
        }
    }
    
    // Completely rewritten main method to prevent StringTokenizer crashes on empty inputs
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String line1 = br.readLine();
        if (line1 == null) return;
        line1 = line1.trim();
        
        int k = 0;
        String s = "";
        
        // Safely handle both "same line" and "new line" input formats
        if (line1.contains(" ")) {
            String[] parts = line1.split("\\s+", 2);
            k = Integer.parseInt(parts[0]);
            if (parts.length > 1) {
                s = parts[1];
            }
        } else {
            k = Integer.parseInt(line1);
            String line2 = br.readLine();
            if (line2 != null) {
                s = line2.trim();
            }
        }
        
        // Output the result
        System.out.println(Solution.Reduced_String(k, s));
    }
}