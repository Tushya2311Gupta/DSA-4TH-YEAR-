public class BitwiseAddition {

    public static int getSum(int a, int b) {
        // Loop until there is no carry left
        while (b != 0) {
            // Step 1: Calculate the carry
            // Only bits that are 1 in both 'a' and 'b' will generate a carry.
            // We shift left by 1 because a carry is added to the next significant bit.
            int carry = (a & b) << 1;
            
            // Step 2: Calculate the sum without the carry
            a = a ^ b;
            
            // Step 3: Assign the carry to 'b' for the next iteration
            b = carry;
        }
        
        return a;
    }
    
    public static void main(String[] args) {
        int a = 15;
        int b = 32;
        System.out.println("Sum of " + a + " and " + b + " is: " + getSum(a, b));
        // Expected output: 47
    }
}