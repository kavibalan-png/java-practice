public class FibonacciSpaceOptimization {

    public static int fib(int n) {

        // Base Case
        if (n <= 1) {
            return n;
        }

        int prev2 = 0;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {

            int current = prev1 + prev2;

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(fib(n));
    }
}


