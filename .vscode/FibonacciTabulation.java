public class FibonacciTabulation {

    public static int fib(int n) {

        // Base Case
        if (n <= 1) {
            return n;
        }

        // DP Array
        int[] dp = new int[n + 1];

        // Store Base Cases
        dp[0] = 0;
        dp[1] = 1;

        // Fill Remaining Values
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(fib(n));
    }
}


