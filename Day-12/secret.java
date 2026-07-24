import java.util.Scanner;

public class secret {
    public static int peopleAwareOfSecret(int n, int delay, int forget) {
        long mod = 1000000007;
        // dp[i] will store the number of NEW people who discover the secret on day i.
        long[] dp = new long[n + 1];
        dp[1] = 1; // On day 1, one person discovers the secret.
        
        long activeSharers = 0; // People who can currently share the secret
        
        for (int i = 2; i <= n; i++) {
            // Add people who just started sharing today
            if (i - delay > 0) {
                activeSharers = (activeSharers + dp[i - delay]) % mod;
            }
            // Subtract people who forgot the secret today
            if (i - forget > 0) {
                activeSharers = (activeSharers - dp[i - forget] + mod) % mod;
            }
            
            // The number of new people today equals the number of active sharers
            dp[i] = activeSharers;
        }
        
        long totalPeople = 0;
        // Sum up all the people who learned the secret in the last 'forget' days
        for (int i = Math.max(1, n - forget + 1); i <= n; i++) {
            totalPeople = (totalPeople + dp[i]) % mod;
        }
        
        return (int) totalPeople;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter n (total days): ");
        int n = scanner.nextInt();

        System.out.print("Enter delay (days until a person can share): ");
        int delay = scanner.nextInt();

        System.out.print("Enter forget (days until a person forgets): ");
        int forget = scanner.nextInt();

        scanner.close();

        int result = peopleAwareOfSecret(n, delay, forget);
        System.out.println("People aware of the secret after " + n + " days: " + result);
    }
}