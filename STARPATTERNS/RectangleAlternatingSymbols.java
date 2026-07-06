package STARPATTERNS;
public class RectangleAlternatingSymbols {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if ((i + j) % 2 == 0)
                    System.out.print("* ");
                else
                    System.out.print("# ");
            }
            System.out.println();
        }
    }
}
