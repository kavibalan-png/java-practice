package STARPATTERNS;
public class Squareincreasingnumbers {
    public static void main(String[] args) {
        int n = 5;
        int num = 1;
        for (int i = 1; i <= n; i++) {      // Rows
            for (int j = 1; j <= n; j++) {  // Columns
                System.out.print(num + " ");
                num++;
            }
            System.out.println();
        }
    }
}
