package STARPATTERNS;
public class SquareBinaryPattern {
    public static void main(String[] args) {
        int n = 5;
        for (int i = 1; i <= n; i++) {      // Rows
            for (int j = 1; j <= n; j++) {  // Columns
                if ((i + j) % 2 == 0) {
                    System.out.print("1 ");
                } else {
                    System.out.print("0 ");
                }
            }
            System.out.println();
        }
    }
}
