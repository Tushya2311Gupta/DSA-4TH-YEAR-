import java.util.Arrays;
import java.util.Scanner;

public class ArrayRotator {

    public static void rotate(int[] nums, int k) {
        // Handle edge cases
        if (nums == null || nums.length < 2) {
            return;
        }
        
        // If k is greater than the array length, we only need to rotate k % length times
        k = k % nums.length;
        if (k == 0) {
            return;
        }

        // Step 1: Reverse the entire array
        reverse(nums, 0, nums.length - 1);
        
        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);
        
        // Step 3: Reverse the remaining elements
        reverse(nums, k, nums.length - 1);
    }

    // Helper method to reverse a portion of the array
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] nums = new int[n];
        int k = 3;
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }
        System.out.println("Original array: " + Arrays.toString(nums));
        rotate(nums, k);
        System.out.println("Rotated array:  " + Arrays.toString(nums));
        sc.close();
    }
}