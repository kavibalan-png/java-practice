package STARPATTERNS;

public class SquareAlphabetPattern {
    public static void main(String[] args) {
        int n = 6;
        char ch = 'A';
        for (int i = 1; i <= n; i++) {      // Rows
            for (int j = 1; j <= n; j++) {  // Columns
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }
}
