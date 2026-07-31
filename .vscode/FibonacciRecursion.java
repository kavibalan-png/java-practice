public class FibonacciRecursion {

    public static int fib(int n) {

        // Base Case
        if (n <= 1) {
            return n;
        }

        // Recursive Calls
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {

        int n = 5;

        System.out.println(fib(n));
    }
}
