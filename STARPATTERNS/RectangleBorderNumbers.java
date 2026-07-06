package STARPATTERNS;
public class RectangleBorderNumbers {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if (i == 1 || i == rows || j == 1 || j == cols)
                    System.out.print("1 ");
                else
                    System.out.print("  ");
            }
            System.out.println();
        }
    }
}