package STARPATTERNS;
public class Square_star_pattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {          // Rows
            for (int j = 1; j <= n; j++) {      // Columns
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}