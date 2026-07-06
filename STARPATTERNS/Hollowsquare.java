package STARPATTERNS;
public class Hollowsquare {//square border stars
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {          // Rows
            for (int j = 1; j <= n; j++) {      // Columns
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}