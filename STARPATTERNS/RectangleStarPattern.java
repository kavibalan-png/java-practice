package STARPATTERNS;
public class RectangleStarPattern {
    public static void main(String[] args) {
        int rows = 3;
        int cols = 6;
        for (int i = 1; i <= rows; i++) {      // Rows
            for (int j = 1; j <= cols; j++) {  // Columns
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
