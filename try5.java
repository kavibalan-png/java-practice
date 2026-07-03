public class try5
 {
    public static void main(String[] args) {
        try {
            int[] numbers = {10, 20, 30};
            System.out.println(numbers[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index.");
        }
        System.out.println("Program End");
    }
}