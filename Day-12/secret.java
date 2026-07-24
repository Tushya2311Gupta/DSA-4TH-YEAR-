import java.util.Scanner;

public class secret {
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = 1000000007;
        long[] dp = new long[n + 1];
        dp[1] = 1;
        
        long activeSharers = 0;
        
        for (int i = 2; i <= n; i++) {
            if (i - delay > 0) {
                activeSharers = (activeSharers + dp[i - delay]) % mod;
            }
            if (i - forget > 0) {
                activeSharers = (activeSharers - dp[i - forget] + mod) % mod;
            }
            dp[i] = activeSharers;
        }
        
        long totalPeople = 0;
        for (int i = Math.max(1, n - forget + 1); i <= n; i++) {
            totalPeople = (totalPeople + dp[i]) % mod;
        }
        return (int) totalPeople;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (total days): ");
        int n = sc.nextInt();

        System.out.print("Enter delay (days until a person can share): ");
        int delay = sc.nextInt();

        System.out.print("Enter forget (days until a person forgets): ");
        int forget = sc.nextInt();

        sc.close();

        int result = peopleAwareOfSecret(n, delay, forget);
        System.out.println("People aware of the secret after " + n + " days: " + result);
    }
}