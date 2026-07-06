package STARPATTERNS;
public class RectangleDecreasingNumbers {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;
        int num = (rows * cols)+10;
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(num + " ");
                num--;
            }
            System.out.println();
        }
    }
}