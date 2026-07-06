package STARPATTERNS;
public class RectangleAlphabetPattern {
    public static void main(String[] args) {
        int rows = 4;
        int cols = 6;
        char ch = 'A';
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                System.out.print(ch + " ");
                ch++;
            }
            System.out.println();
        }
    }
}
