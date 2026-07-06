package STARPATTERNS;

public class HollowRectangle {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;
        for (int i = 1; i <= rows; i++) {      // Rows
            for (int j = 1; j <= cols; j++) {  // Columns
                if (i == 1 || i == rows || j == 1 || j == cols) {
                    System.out.print("* ");
                } else {
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }
}
