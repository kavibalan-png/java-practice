package STARPATTERNS;
public class RectangleEvenNumbers {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;
        int num = 12;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(num + " ");
                num += 2;
            }
            System.out.println();
        }
    }
}