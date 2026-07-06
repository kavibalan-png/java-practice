package STARPATTERNS;
public class SquareAlternatingStarsAndNumbers {
    public static void main(String[] args) {
        int n = 5;
        int num = 1;
        for (int i = 1; i <= n; i++) {      // Rows
            for (int j = 1; j <= n; j++) {  // Columns
                if ((i + j) % 2 != 0) {
                    System.out.print(num + " ");
                    num++;
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
    }
}
