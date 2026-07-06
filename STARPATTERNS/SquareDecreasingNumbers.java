package STARPATTERNS;
public class SquareDecreasingNumbers {
    public static void main(String[] args) {
        int n = 5;
        int num = n * n;   // 25
        for (int i = 1; i <= n; i++) {      // Rows
            for (int j = 1; j <= n; j++) {  // Columns
                System.out.print(num + " ");
                num--;
            }
            System.out.println();
        }
    }
}