
import java.util.Arrays;

public class FibonacciDP {

    static int[] dp;

    public static int fib(int n) {

        // Base Case
        if (n <= 1) {
            return n;
        }

        // Already Calculated
        if (dp[n] != -1) {
            return dp[n];
        }

        // Calculate and Store
        dp[n] = fib(n - 1) + fib(n - 2);

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        dp = new int[n + 1];

        Arrays.fill(dp, -1);

        System.out.println(fib(n));
    }
}